package chapter10;

public class MazingerToyImpl implements IMissile, IMoveArmLeg {

	public MazingerToyImpl() {
		System.out.println("마징가입니다.");
		canMissile();
		canMoverArmLeg();
		System.out.println("=====================================");
	}

	@Override
	public void canMoverArmLeg() {
		System.out.println("마징가 팔다리 움직이기!!!");
	}

	@Override
	public void canMissile() {
		System.out.println("대포동 미사일 발사!!!");
	}

}
