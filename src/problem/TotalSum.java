package problem;

public class TotalSum {

	public static void main(String[] args) {

		// 1 ~ 100까지 수 중에 짝수, 홀수 각각 더해서 출력하시오.

		int even = 0;
		int odd = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
		System.out.println("1 ~ 100까지 짝수총합 = " + even);
		System.out.println("1 ~ 100까지 홀수총합 = " + odd);
	}
}
