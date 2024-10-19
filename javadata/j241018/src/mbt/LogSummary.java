package mbt;

import java.io.*; // 파일 입출력 관련 클래스들을 포함하여 사용하기 위해 import
import java.util.*; // 컬렉션 프레임워크(Map, List 등) 사용을 위한 import

public class LogSummary { // LogSummary 클래스 정의, 파일 요약 기능을 담당
    public static void main(String[] args) { // 프로그램의 시작점인 main 메서드
        // 로그 파일 경로와 결과 파일을 저장할 폴더 경로를 설정
        String logFilePath = "/Users/lee/Library/Mobile Documents/com~apple~CloudDocs/javadata/log.txt";
        String outputFolder = "/Users/lee/Library/Mobile Documents/com~apple~CloudDocs/javadata/output_logs";
        // String logFilePath = "C:\\javadata\\log.txt";
        // String outputFolder = "C:\\javadata\\output_logs";
        new File(outputFolder).mkdirs(); // 지정된 경로에 폴더가 없으면 새 폴더를 생성

        // 요청 수와 관련된 통계를 저장하기 위한 Map, IP 주소를 키로 사용
        Map<String, RequestStats> requestStatsMap = new HashMap<>();
        // 캐시 히트 상태를 나타내는 문자열을 저장한 Set, 비교를 빠르게 하기 위해 사용
        Set<String> cacheHitActions = new HashSet<>(Arrays.asList("TCP_HIT", "TCP_IMS_HIT", "TCP_REFRESH_HIT"));

        // 로그 파일을 읽고 분석하여 요청 수 통계를 계산
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) { 
            String line; // 파일에서 읽어온 각 줄을 저장할 변수
            while ((line = reader.readLine()) != null) { // 파일의 끝까지 한 줄씩 읽기
                // 주석(#)으로 시작하거나 빈 줄은 무시하고 다음 줄로 넘어감
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue; // 조건에 맞으면 아래 코드를 건너뛰고 다음 줄 처리
                }

                // 공백을 기준으로 로그 데이터를 분리하여 배열에 저장
                String[] parts = line.split("\\s+");
                // 배열의 길이가 9 미만이면 필요한 정보가 없는 줄로 간주하고 건너뜀
                if (parts.length < 9) continue;

                String ip = parts[3];  // 배열의 네 번째 요소를 IP 주소로 사용
                String status = parts[4];  // 배열의 다섯 번째 요소를 응답 상태로 사용
                String action = parts[5];  // 배열의 여섯 번째 요소를 캐시 히트 상태로 사용
                String method = parts[8];  // 배열의 아홉 번째 요소를 HTTP 메서드로 사용 (예: GET, POST)

                // IP별 요청 수 통계를 저장하고 업데이트
                requestStatsMap.putIfAbsent(ip, new RequestStats()); // IP가 없으면 새 객체를 생성
                RequestStats stats = requestStatsMap.get(ip); // 해당 IP의 RequestStats 객체 가져오기

                stats.totalRequests++; // 해당 IP의 총 요청 수 증가
                // 해당 HTTP 메서드의 요청 수를 증가 (기본값이 없을 경우 0에서 시작)
                stats.methodCounts.put(method, stats.methodCounts.getOrDefault(method, 0) + 1);

                // 응답 상태가 200 또는 201이 아닌 경우 오류로 간주하여 오류 수 증가
                if (!status.equals("200") && !status.equals("201")) {
                    stats.errorCount++;
                }

                // 캐시 히트 상태인지 확인하고, 해당될 경우 캐시 히트 수 증가
                if (cacheHitActions.contains(action)) {
                    stats.cacheHitCount++;
                }
            }

            // IP별 요청 수를 기준으로 정렬된 리스트를 생성 (총 요청 수 기준으로 내림차순)
            List<Map.Entry<String, RequestStats>> sortedEntries = new ArrayList<>(requestStatsMap.entrySet());
            sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().totalRequests, entry1.getValue().totalRequests));

            // 요약 파일(summary.txt)을 생성하고 분석 결과를 저장
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFolder + File.separator + "summary.txt"))) {
                // 결과 파일의 헤더 작성
                writer.write("IP, 파일 명, 전체 요청 건수, GET, POST, PUT, DELETE, 오류율, 캐시 히트율");
                writer.newLine(); // 줄 바꿈 추가

                // 정렬된 각 IP에 대해 통계를 파일에 기록
                for (Map.Entry<String, RequestStats> entry : sortedEntries) {
                    String ip = entry.getKey(); // 현재 IP 주소
                    RequestStats stats = entry.getValue(); // 해당 IP의 통계 객체
                    int total = stats.totalRequests; // 해당 IP의 총 요청 수
                    // 오류율과 캐시 히트율 계산 (전체 요청이 0인 경우 0%)
                    double errorRate = (total > 0) ? (double) stats.errorCount / total * 100 : 0;
                    double cacheHitRate = (total > 0) ? (double) stats.cacheHitCount / total * 100 : 0;

                    // IP별 통계 정보를 형식에 맞게 파일에 기록
                    String summary = String.format("%s, %s.txt, %d, %d, %d, %d, %d, %.1f, %.1f", 
                        ip, ip, total, 
                        stats.methodCounts.getOrDefault("GET", 0), 
                        stats.methodCounts.getOrDefault("POST", 0), 
                        stats.methodCounts.getOrDefault("PUT", 0), 
                        stats.methodCounts.getOrDefault("DELETE", 0), 
                        errorRate, cacheHitRate);

                    writer.write(summary); // 요약 정보를 파일에 기록
                    writer.newLine(); // 다음 줄로 이동
                }
            }

            System.out.println("요약 파일이 성공적으로 생성되었습니다."); // 요약 파일 생성 완료 메시지 출력
        } catch (IOException e) { // 입출력 관련 예외 발생 시 처리
            e.printStackTrace(); // 오류의 상세 내용을 출력하여 문제를 파악
        }
    }
}

// 요청 통계를 저장하는 클래스 정의
class RequestStats {
    int totalRequests = 0; // 총 요청 수를 저장할 변수
    int errorCount = 0; // 오류 발생 횟수를 저장할 변수
    int cacheHitCount = 0; // 캐시 히트 발생 횟수를 저장할 변수
    Map<String, Integer> methodCounts = new HashMap<>(); // HTTP 메소드별 요청 수를 저장할 Map
}