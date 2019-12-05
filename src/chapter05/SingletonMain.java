package chapter05;

public class SingletonMain {
	public static void main(String[] args) {
		// SingletonTest st = new SingletonTest();
		SingletonTest st1 = SingletonTest.getInstance();
		SingletonTest st2 = SingletonTest.getInstance();
		System.out.println(st1 == st2);
	}
}
