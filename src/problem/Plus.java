package problem;

import java.util.Scanner;

public class Plus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 >> ");
		int num = sc.nextInt();

		int fst = num / 100;
		System.out.println(fst);

		int sec = num - (fst * 100);
		int sec2 = sec % 10;
		System.out.println(sec2);
		
		int thd = (sec - sec2) / 10;
		System.out.println(thd);

		System.out.println(fst + thd + sec2);
	}
}
