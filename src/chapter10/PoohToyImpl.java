package chapter10;

public class PoohToyImpl implements IMoveArmLeg {

	public PoohToyImpl() {
		System.out.println("푸에요~");
		canMoverArmLeg();
		System.out.println("=====================================");
	}

	@Override
	public void canMoverArmLeg() {
		System.out.println("푸가 뒤뚱뒤뚱 움직입니다.");

	}

}
