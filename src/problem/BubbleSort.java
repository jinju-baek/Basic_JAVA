package problem;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] data = new int[5];
		int num = 0;

		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒Bubble Sort▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

		// 입력부
		for (int i = 0; i < data.length; i++) {
			while (true) {
				// 중복값 검사
				System.out.print("▒▒ 값 입력 >> ");
				num = sc.nextInt();

				if (duplicateData(num, data)) {
					break;
				}
			}
			data[i] = num;
		}

		// 출력부
		System.out.print("▒▒ 입력값 >> ");
		viewData(data);

		// 버블정렬
		bubbleSort(data);
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.print("▒▒ 결과 >> ");
		viewData(data);

	}

	// 중복값 검사
	public static boolean duplicateData(int num, int[] data) {
		boolean flag = true;

		for (int i = 0; i < data.length; i++) {
			if (data[i] == num) {
				flag = false;
			}
		}
		return flag;
	}

	// 출력부
	public static void viewData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	// 버블 정렬
	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < (data.length - i) - 1; j++) {
				if (data[j] > data[j + 1]) {
					int tmp = 0;
					tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
			System.out.println();
			viewData(data);
			System.out.print(" ");
		}
		System.out.println();
	}

}
