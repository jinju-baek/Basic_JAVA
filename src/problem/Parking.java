package problem;

public class Parking {
	int[] space = new int[5]; // 주차공간 5대
	int carCnt;

	// 1. 주차타워 현황
	public void viewParking() {
		System.out.println("================");
		for (int j = 0; j < space.length; j++) {
			System.out.println("ㅣㅣ" + (j + 1) + "층:" + space[j] + "ㅣㅣ");
		}
		System.out.println("================");
	}

	// 2. 주차타워 입고
	public void inParking(int car) {
		// 차량입고 비즈니스 로직
		// 1. 주차공간이 여유가 있는지 체크
		// full : 다른 타워를 이용하세요~ 끝냄
		// ok : 2번으로 넘어감
		// 2. 차량번호 중복 체크
		// 중복 : 차량번호를 다시 입력해주세요~
		// ok : 3번으로 넘어감
		// 3. 주차타워에 차량을 입고
		// ok : 입고완료, 주차현황 출력

		// 현재 주차타워에 빈 공간이 없는 경우
		if (carCnt == space.length) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 공간이 부족합니다. 2번타워를 이용해주세요.");
			return; // 메서드 실행종료!
		}

		// 중복차량유무 체크
		/*
		 * for (int i = 0; i < space.length; i++) { if (space[i] == car) {
		 * System.out.println("중복된 차량입니다. 다시 입력해주세요"); return; } }
		 */

		if (searchCar(car)) { // 중복차량
			System.out.println("▒▒ 이미 주차중인 차량번호입니다.");
			System.out.println("▒▒ 차량번호를 확인하시고 다시 입고해주세요");
			return;
		}

		// 주차공간을 순회하면서 비어있는(입고 할 공간)을 찾음
		for (int i = 0; i < space.length; i++) {
			// 비어있는 공간을 찾음(값이 0이면 비어 있음)
			if (space[i] == 0) {
				space[i] = car;
				carCnt += 1;
				// carCnt = carCnt + 1;
				System.out.println("▒▒ " + (i + 1) + "층:" + car + " 입고완료!");
				viewParking();
				break;
			}
		}
	}

	// 3. 주차타워 출고
	public void outParking(int car) {
		// 주차타워에 차량이 0대인 경우
		if (carCnt == 0) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 주차중인 차량이 없습니다.");
			return;
		}
		for (int i = 0; i < space.length; i++) {
			// 주차된 차량번호와 내가 입력한 차량번호가 같을 때
			if (space[i] == car) {
				space[i] = 0; // 출고 => 공간
				carCnt -= 1; // 현재 주차차량 -1
				System.out.println("▒▒ " + (i + 1) + "층:" + car + " 출고완료! 안녕히가세요");
				viewParking();
				return;
			}
		}
		// 입력한 차량번호가 해당주차타워에 없음!!
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒ 없는 차량번호입니다. 다시 입력해주세요.");
		return;
	}

	// 4. 검색 : 현재 차량번호 기존에 등록된 차량번호 중복체크
	public boolean searchCar(int car) {
		boolean flag = false; // 중복유무 판별(f : 정상, t : 중복)
		for (int i = 0; i < space.length; i++) {
			if (space[i] == car) {
				flag = true; // 차량번호 중복
			}
		}
		return flag;
	}

}
