package chapter12;

import java.util.HashMap;

public class HashMap01 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("선생님", "초롱");
		map.put("강아지", "체리");
		System.out.println(map.get("선생님"));
	}
}
