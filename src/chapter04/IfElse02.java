package chapter04;

import java.util.Scanner;

public class IfElse02 {

	public static void main(String[] args) {
		// 학점 계산 프로그램
		Scanner sc = new Scanner(System.in);

		String grade = ""; // 학점 등급
		int score = 0;

		while (true) {
			System.out.print("학생점수 >> ");
			score = sc.nextInt();
			if (score > 100 || score < 0) {
				System.out.println("0 ~ 100 : 다시 입력");
			} else {
				break;
			}
		}
		
		// 90 점 이상 A등급
		// 80 점 이상 B등급
		// 70 점 이상 C등급
		// 60 점 이상 D등급
		// 60 점 미만 F등급
		if (score >= 90 && score <= 100) {
			grade = "A";
		} else if (score >= 80 && score < 90) {
			grade = "B";
		} else if (score >= 70 && score < 80) {
			grade = "C";
		} else if (score >= 60 && score < 70) {
			grade = "D";
		} else if (score < 60 && score >= 0) {
			grade = "F";
		} else {
			System.out.println("총점은 100점입니다. 다시 입력해주세요.");
		}
		System.out.println(grade + "등급 입니다.");
	}
}
