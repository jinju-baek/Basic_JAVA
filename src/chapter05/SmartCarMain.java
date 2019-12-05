package chapter05;

public class SmartCarMain {
	public static void main(String[] args) {
		SmartCar car = new SmartCar();
		// 은닉하고 싶은 변수에 private을 선언하여
		// 외부에서 다이렉트로 접근이 불가능하게 막음
		// car.speed = 300;

		// 개발을 위해서는 정상적인 방법으로은
		// 은닉한 변수에 접근이 가능하게 만들어야함
		// = Getter() & Setter()
		// setter()를 통해 값을 초기화
		car.setSpeed(60);
		// getter()를 통해 값을 출력
		System.out.println(car.getSpeed());
		// car.drive();
	}
}
