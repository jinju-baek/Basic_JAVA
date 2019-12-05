package chapter09;

// 추상메서드 반드시 추상클래스 필요함
// 추상클래스는 추상메서드 없어도 됨
// 추상클래스는 부모클래스로만 사용 가능
public abstract class Animal {
	public String kind;
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}

	public abstract void sound(); // 추상메서드
}
