package chapter04;

import java.util.Scanner;

public class IfElse01 {

	public static void main(String[] args) {
		// 제어문
		// 1. 조건문
		// - if ~ else
		// - switch ~ case(잘 사용 x)
		// 2. 반복문
		// - for(반복 횟수가 정해졌을 때)
		// - while(반복 횟수가 정해져있지 않을 때)

		// if(조건문) {
		// 조건문이 참인 경우 실행
		// } else if(조건문) {
		// else if 조건문이 참인 경우 실행
		// } else {
		// 조건문 결과 제외하고 전부 다 실행
		// }

		Scanner sc = new Scanner(System.in);
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒군대갈래? ver1.0");
		System.out.println("▒▒번호를 입력하세요.");
		System.out.print("▒▒  1:남성 2:여성  >> ");
		int num = sc.nextInt();
		// 1:남성, 2:여성
		if (num == 1) {
			System.out.println("군대 잘 다녀와유,,");
		} else if (num == 2) {
			System.out.println("군대 안가셔도 돼요~");
		} else {
			System.out.println("1과 2만 입력해주세요.");
		}
	}
}
