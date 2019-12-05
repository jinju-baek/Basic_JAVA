package problem;

import java.util.Scanner;

public class ReversePrint {

	public static void main(String[] args) {
		// 조건
		// 1. 사용자가 임의의 정수를 입력
		// 2. 사용자가 입력한 정수를 역으로 1까지 출력
		// 출력 예제
		// 입력 >> 5
		// 5
		// 4
		// 3
		// 2
		// 1

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 >> ");
		int num = sc.nextInt();

		for (; num >= 1; num--) {
			System.out.println(num);
		}
	}
}
