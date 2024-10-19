package sorting;

public class HeapSort implements Sort { // 인터페이스의 메서드를 오버라이딩하여 힙 정렬 알고리즘을 구현

	@Override
	public void ascending(int[] arr) {
		
		System.out.println("HeapSort ascending");
	}

	@Override
	public void descending(int[] arr) {
		
		System.out.println("HeapSort descending");
	}

	@Override
	public void description() {
		
		System.out.println("숫자를 정렬하는 알고리즘입니다");
		System.out.println("HeapSort 입니다");
	}
}
