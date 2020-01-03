package market;

import java.util.Scanner;

public class MarketMain {
	String id = "admin";
	String pw = "1234";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarketMain mm = new MarketMain();
		Boolean flag = false;
		
		String userid = "";
		String userpw = "";
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■ Marcket System Ver1.0 ■■■■■■■■■■■■■■■■■■■■■■");
				
	/*	do {
			System.out.println("■■ [Msg] Please login to use.");
			System.out.print("■■ ID >> ");
			userid = sc.nextLine();
			System.out.print("■■ PW >> ");
			userpw = sc.nextLine();
		} while (mm.login(userid, userpw));*/
				
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■ 1. 물건 판매");
			System.out.println("■■ 2. 제품 등록");
			System.out.println("■■ 3. 제품 삭제");
			System.out.println("■■ 4. 제품 조회");
			System.out.println("■■ 5. 제품 검색");
			System.out.println("■■ 6. 일일 매출현황");
			System.out.println("■■ 7. 프로그램 종료");
			
			System.out.print("■■ 입력 >> ");
			int code = sc.nextInt();
			
			if(code == 1) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 구매하실 제품 번호와 수량을 입력해주세요.");
				System.out.print("■■ 제품 번호 >> ");
				int pno = sc.nextInt();
				System.out.print("■■ 구입 수량 >> ");
				int cnt = sc.nextInt();
				
				pDao.salePdt(pno, cnt);
				
				
			} else if(code == 2) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 제품의 이름을 입력하세요.");
				System.out.print("■■ 제품명 >> ");
				sc.nextLine();
				String pname = sc.nextLine();
				
				if(pDao.pdtAlready(pname)) { // 기존에 등록된 제품이므로 추가기능
					// 입고수량 입력받음
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 기존에 있는 제품입니다. 입고된 수량을 입력해주세요.");
					System.out.print("■■ 입고 수량 >> ");
					int cnt = sc.nextInt();
					
					pDao.cntPlusPdt(pname, cnt);	
					
				} else { // 최초 등록된 제품이므로 등록기능
					// 제조회사, 가격, 입고수량 입력받음
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 기존에 없는 제품입니다. 등록 후 입고해주세요.");
					System.out.print("■■ 제조회사 >> ");
					String company = sc.nextLine();
					System.out.print("■■ 가격 >> ");
					int price = sc.nextInt();
					System.out.print("■■ 입고 수량 >> ");
					int cnt = sc.nextInt();
					
					pDao.insertPdt(pname, company, price, cnt);
					
				}
			
			} else if(code == 3) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 삭제하실 제품명을 입력해주세요.");
				System.out.print("■■ 제품명 >> ");
				sc.nextLine();
				String pname = sc.nextLine();
				if(pDao.pdtAlready(pname)) {
					pDao.deletePdt(pname);
				} else {
					System.out.println("■■ 기존에 없는 제품입니다. 다시 확인해주세요.");
				}
					
			} else if(code == 4) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				
				pDao.selectPdt();
				
			} else if(code == 5) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 검색하실 키워드를 입력해주세요.");
				System.out.print("■■ 키워드 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				
				pDao.searchPdt(keyword);
				
			} else if(code == 6) {
				
			} else if(code == 7) {
				System.out.println("■■ [Msg] Exit the program.");
				System.exit(0);
			}else {
				System.out.println("■■ [Msg] Please enter a valid value.");
				continue;
			}
		}
	}
	
	public boolean login(String userid, String userpw) {
		boolean flag = true;
		if(id.equals(userid) && pw.equals(userpw)) {
			flag = false;
			System.out.println("■■ 관리자로 로그인 되셨습니다.");
		} else {
			System.out.println("■■ [Msg] Login denied.");
		}
		return flag;
	}
}
