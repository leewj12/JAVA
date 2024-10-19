package mbt;

import java.io.*;
import java.util.*;

public class LogAnalyzer {

    // 주어진 로그 파일을 읽고, 각 IP 주소별로 로그를 분리하여 별도의 파일로 저장하는 메서드
    public static void separateLogsByIP(String inputFilePath, String outputFolder) throws IOException {
        // IP 주소를 키로 사용하여, 해당 IP로 발생한 로그 리스트를 값으로 저장
        // 여러 로그가 하나의 IP에서 발생할 수 있으므로, IP별로 그룹화하기 위해 HashMap을 사용
        // HashMap은 순서에 상관없이 빠르게 데이터를 접근할 수 있어 적합 (정렬이 필요할 경우 TreeMap 사용 가능)
        Map<String, List<String>> ipLogMap = new HashMap<>();

        // BufferedReader는 파일을 한 줄씩 읽어오는데 내부적으로 버퍼를 사용하여 디스크 I/O 호출을 최소화
        // readLine() 메서드를 이용하여 줄 단위로 처리하는 데 유리하며, 파일 크기가 큰 경우에도 안정적으로 처리 가능
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 주석(#)으로 시작하거나 빈 줄은 로그 분석에서 제외
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }

                // 공백을 기준으로 로그 데이터를 분리하여 배열에 저장
                String[] parts = line.split(" ");
                // 정보의 갯수가 적을 경우 잘못된 형식으로 간주하고 건너뜀
                if (parts.length < 10) continue;

                // 배열의 네 번째 요소가 IP 주소이므로 이를 추출
                String ip = parts[3];

                // computeIfAbsent를 사용하여 IP가 존재하지 않으면 새 ArrayList를 생성 후 해당 리스트에 로그 추가
                // 존재하면 해당 키에 해당하는 리스트를 반환하여 로그를 추가
                ipLogMap.computeIfAbsent(ip, k -> new ArrayList<>()).add(line);
            }
        }

        // 각 IP별로 로그 파일을 생성하고 데이터를 기록
        for (Map.Entry<String, List<String>> entry : ipLogMap.entrySet()) {
            String ip = entry.getKey(); // 현재 IP 주소
            List<String> logs = entry.getValue(); // 해당 IP에 대한 로그 리스트

            // BufferedWriter를 사용하여 메모리 버퍼에 모아 두었다가 파일에 기록
            // try-with-resources 구문을 사용하여 자동으로 자원을 해제
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFolder + "/" + ip + ".txt"))) {
                for (String log : logs) {
                    writer.write(log); // 로그를 파일에 기록
                    writer.newLine(); // 줄 바꿈 추가
                }
            }
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        // 로그 파일 경로와 출력 폴더 경로 지정
        String logFilePath = "/Users/lee/Library/Mobile Documents/com~apple~CloudDocs/javadata/log.txt";
        String outputFolder = "/Users/lee/Library/Mobile Documents/com~apple~CloudDocs/javadata/output_logs";
//        String logFilePath = "C:\\javadata\\log.txt";
//        String outputFolder = "C:\\javadata\\output_logs";
        new File(outputFolder).mkdirs(); // 출력 폴더 생성

        try {
            // IP별 로그 파일 분리 메서드 호출
            separateLogsByIP(logFilePath, outputFolder);
            System.out.println("IP별 로그 파일 생성 완료"); // 성공 메시지 출력
        } catch (IOException e) {
            // 파일 처리 중 오류 발생 시 오류 메시지 출력
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}