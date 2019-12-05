package chapter05;

public class SmartCar {
	// 캡슐화가 되어 해당 Class에서만 사용가능
	// 외부에서는 접근불가능
	
	private int speed; // 전역변수 선언, 자동차 속도
	private boolean breakCar;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isBreakCar() {
		return breakCar;
	}

	public void setBreakCar(boolean breakCar) {
		this.breakCar = breakCar;
	}

	// 엑셀을 밟았을 때 동작하는 메서드
	public void drive() {
		System.out.println(speed);
	}

}
