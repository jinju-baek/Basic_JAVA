package chapter05;

public class Constructor01 {
	// default 생성자
	// : Class에 생성자가 존재하지 않으면
	// JAVA에서 Default 생성자를 생성
	// Default 생성자는 객체생성만 함
	// 1. 매개변수의 갯수가 다르면 됨
	// 2. 매개변수의 갯수가 같으면 타입이 다르면 됨
	// 3. 매개변수의 갯수와 타입이 같다면 순서가 다르면 됨
	public Constructor01() {} //Default
	public Constructor01(String a) {}
	public Constructor01(int a) {}
	public Constructor01(int a, int b, String c) {}
	public Constructor01(int a, String c, int b) {}

}
