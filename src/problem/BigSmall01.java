package problem;

import java.util.Scanner;

public class BigSmall01 {

	public static void main(String[] args) {
		// 사용자가 2개의 값을 입력
		// -- 입력 --
		// 번호1>> 5
		// 번호2>> 7
		// -- 조건 --
		// 번호1 < 번호2보다 작으면
		// 번호1에 값과 번호2의 값을 서로 교환하여
		// 번호1이 항상 큰 수를 가지게 만든다.
		// -- 출력 --
		// 번호1 > 번호2

		Scanner sc = new Scanner(System.in);
		System.out.print("번호1>> ");
		int num1 = sc.nextInt();
		System.out.print("번호2>> ");
		int num2 = sc.nextInt();

		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		System.out.println(num1 + " > " + num2);

		// System.out.println(num1 + ", " + num2);

	}
}
