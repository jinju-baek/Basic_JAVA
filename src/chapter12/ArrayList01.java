package chapter12;

import java.util.ArrayList;

public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("딸기"); // 값 입력
		list.add("샤인머스캣"); // 값 입력
		list.add("복숭아"); // 값 입력
		list.add(1, "망고"); // (index, value)
		list.set(3, "오렌지");
		list.remove(3);
		// int[] array = new int[5];
		// array[0] = 3;

		// 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (String val : list) {
			System.out.println(val);
		}
	}
}
