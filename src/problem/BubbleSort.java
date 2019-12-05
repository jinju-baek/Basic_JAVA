package problem;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] Arr = new int[5];

		// 배열에 입력받기
		for (int i = 0; i < Arr.length; i++) {
			System.out.print("값 입력 >> ");
			Arr[i] = sc.nextInt();
		}

		// 중복 체크

		// 버블 정렬
		for (int i = 0; i < Arr.length - 1; i++) {
			for (int j = 0; j < Arr.length - 1; j++) {
				if (Arr[j] > Arr[j + 1]) {
					int tmp = 0;
					tmp = Arr[j];
					Arr[j] = Arr[j + 1];
					Arr[j + 1] = tmp;
				}
			}
			System.out.println();
			for (int k = 0; k < Arr.length; k++) {
				System.out.print(Arr[k] + " ");
			}
		}

		System.out.println();

		// 배열 처음부터 끝까지 출력
		System.out.println("==========결과=========");
		for (int k = 0; k < Arr.length; k++) {
			System.out.print(Arr[k] + " ");
		}
	}
}