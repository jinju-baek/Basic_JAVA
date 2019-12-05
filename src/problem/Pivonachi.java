package problem;

import java.util.Scanner;

public class Pivonachi {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력 >> ");

		int scan = sc.nextInt();
		int x = 0;

		int num1 = 1;
		int num2 = 1;
		int sum = 2;
		int tot = 2;

		for (int i = 0; i < scan - 1; i++) {
			tot += sum;
			num1 = num2;
			num2 = sum;
			sum = num1 + num2;
			System.out.println(tot);
		}
		System.out.println("최종 : " + tot);

	}
}
