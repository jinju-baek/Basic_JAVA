package chapter09;

// 추상클래스를 상속받는 자식 클래스
public class Dog extends Animal {
	public Dog() {
		this.kind = "강아지";
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
