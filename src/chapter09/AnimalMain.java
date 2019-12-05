package chapter09;

public class AnimalMain {
	public static void main(String[] args) {
		// 추상클래스는 단독으로 객체생성 불가!
		// 추상클래스는 사요하기 위해서는 반듸
		// 추상클래스를 상속받는 자식을 통해서만 사용 가능
		// Animal ai = new Animal();

		Dog dog = new Dog();
		Cat cat = new Cat();
		// System.out.println(dog.kind);
		// System.out.println(cat.kind);

		dog.sound();
		cat.sound();
		System.out.println("=======================");

		// 다형성
		// : 여러가지 타입을 하나로 묶어서 사용
		// 1. 부모-자식관계를 가져야함
		// 2. 부모클래스 타입으로만 묶을 수 있음
		// Dog클래스는 Animal 클래스를 상속받고 있고
		// 1. 부모(Animal)-자식(Dog)
		// 2. 부모클래스 타입(Animal)로 묶을 수 있음

		Animal animal = new Dog();
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		System.out.println("=======================");

		animal = new Dog();
		animalSound(animal);
	}

	public static void animalSound(Animal animal) {
		animal.sound();
	}
}
