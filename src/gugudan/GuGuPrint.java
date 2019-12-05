package gugudan;

public class GuGuPrint {
	
	public void guGuDan(int dan) {
		
		int result = 0;
		System.out.println("<구구단 " + dan + "단 출력>");

		for (int i = 1; i <= 9; i++) {
			result = dan * i;
			System.out.println(dan + " * " + i + " = " + result);
		}
	}
}
