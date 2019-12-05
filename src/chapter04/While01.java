package chapter04;

public class While01 {
	public static void main(String[] args) {
		// 횟수가 정해져있지 않은 반복

		// while(조건문){
		// 조건이 참인 경우 반복적으로 실행되는 코드
		// }

//		// 무한루프
//		while (true) {
//			System.out.println("참인 경우 반복");
//		}
		// 1 ~ 10까지 수를 출력 멈춰라;
		int num = 1;
		while (true) {
			System.out.println(num);
			num = num + 1;
			if (num > 10) break;
		}
	}
}
