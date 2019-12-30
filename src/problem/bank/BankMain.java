package problem.bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		BankDTO bDto = new BankDTO();
		int code = 0;
		
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■ 허쉬 은행");
			System.out.println("■■ 1. 계좌 개설");
			System.out.println("■■ 2. 계좌 해지");
			System.out.println("■■ 3. 입금");
			System.out.println("■■ 4. 출금");
			System.out.println("■■ 5. 고객조회");
			System.out.println("■■ 6. 계좌조회");
			System.out.println("■■ 7. 사용자 검색");
			System.out.println("■■ 8. 프로그램 종료");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			// 1. 프로그램 전체 반복
			// 2. 1 ~ 6번까지 번호만 허용(나머지는 무한반복 다시 입력)
			// 3. 계좌 개설(INSERT)
			// 4. 계좌 조회(SELECT, 전체조회)
			// 5. 사용자 검색 만들기(이름으로)
			// 6. 프로그램 종료기능
			while (true) {
				System.out.print("■■ 번호 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("■■ 잘못된 값입니다. 1 ~ 6중 다시 입력해주세요.");
					continue;
				}
			}
			
			if (code == 1) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 개설하실 계좌의 정보를 입력해주세요.");
				System.out.print("■■ 계좌주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("■■ 계좌 비밀번호 >> ");
				String pw = sc.nextLine();
				
				bDao.insertBank(bname, pw);
				
			} else if(code == 2) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 삭제하실 계좌의 정보를 입력해주세요.");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("■■ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				bDao.deleteBank(bno, pw);
				
			} else if (code == 3) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 입금하실 계좌의 번호를 입력해주세요");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.println("■■ 입금하실 금액을 입력해주세요");
				System.out.print("■■ 입금금액 >> ");
				int money = sc.nextInt();
				
				bDao.updateMoney(bno, money);
				
			} else if (code == 4) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 인출하실 계좌의 번호를 입력해주세요");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.println("■■ 비밀번호를 입력해주세요");
				System.out.print("■■ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				while(true) {
					int result = bDao.bankCheck(bno, pw);
					if(!(result > 0)) {
						System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
						System.out.println("■■ 없는 계좌이거나, 비밀번호가 틀렸습니다. 다시 입력해주세요.");
						System.out.print("■■ 계좌번호 >> ");
						bno = sc.nextInt();
						System.out.println("■■ 비밀번호를 입력해주세요");
						sc.nextLine();
						System.out.print("■■ 비밀번호 >> ");
						pw = sc.nextLine();
					} else {
						break;
					}
				}
				System.out.println("■■ 인출하실 금액을 입력해주세요");
				System.out.print("■■ 금액 >> ");
				int dept = sc.nextInt();
				int result = bDao.moneyCheck(bno, dept);
				if (result > 0) {
					bDao.bankWithDraw(bno, dept);
				} else {				
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("금액이 부족합니다.");
				}
			} else if (code == 5) {
				bDao.bankSelect();
				
			} else if (code == 6) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 계좌를 조회합니다. 계좌번호와 비밀번호를 입력해주세요");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("■■ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				
				bDao.selectAccount(bno, pw);
				
				
				
			} else if (code == 7) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 검색하실 예금주 키워드를 입력해주세요.");
				System.out.print("키워드 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				
				bDao.bankSearch(keyword);
				
			} else if (code == 8) {
				System.exit(0);
			}
		}
	}
}
