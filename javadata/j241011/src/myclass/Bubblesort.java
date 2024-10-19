package myclass;

public class Bubblesort {

	static int[] BubbleS(int a[], int n) {
//파이썬
//  	for i in range(n-1, 0, -1):
//         for j in range(i):
//            if a[j] > a[j+1]:
//                temp = a[j]
//                a[j] = a[j+1]
//                a[j+1] = temp
//		return a;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		// 파이썬 list1 = [55, 7, 78, 12,42]
		int[] list1 = { 55, 7, 78, 12, 42 };
		// 파이썬 pirnt(list1)
		for (int x : list1)
			System.out.print(x + " ");
		System.out.println("\n" + "");
		// n = len(list1)
		int n = list1.length;
		// 파이썬 print(BubbleSort(list1, n))
		for (int x : BubbleS(list1, n))
			System.out.print(x + " ");
	}

}
