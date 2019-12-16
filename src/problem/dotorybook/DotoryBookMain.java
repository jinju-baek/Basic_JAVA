package problem.dotorybook;

import java.util.Scanner;

public class DotoryBookMain {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			System.out.println("◎◎ 도토리 서점 관리 시스템 ver1.2");
			System.out.println("◎◎ 1. 도서 등록");
			System.out.println("◎◎ 2. 도서 수정");
			System.out.println("◎◎ 3. 도서 삭제");
			System.out.println("◎◎ 4. 도서 조회");
			System.out.println("◎◎ 5. 도서 검색");
			System.out.println("◎◎ 6. 만든이");
			System.out.println("◎◎ 7. 프로그램 종료");
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			int code = 0;
			while(true) {
				System.out.print("◎◎ 번호 >> ");
				code = sc.nextInt();
				if(code >= 1 && code <= 7) {
					break;
				}else {
					System.out.println("◎◎ 1 ~ 7까지만 입력해주세요.");
					continue;
				}
			}
			
			BookDAO bDao = new BookDAO();
			if (code == 1 ) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 등록할 도서 정보를 입력해주세요.");
				System.out.print("◎◎ 도서명 >> ");	
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("◎◎ 가격 >> ");
				int price = sc.nextInt();
				System.out.print("◎◎ 출판사 >> ");
				sc.nextLine();
				String company = sc.nextLine();
				System.out.print("◎◎ 저자 >> ");
				String writer = sc.nextLine();
				
				BookDTO bDto = new BookDTO(bname, price, company, writer);
				bDao.BookInsert(bDto);
				
			}else if (code == 2) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 수정할 도서 정보를 입력해주세요.");
				System.out.print("◎◎ 도서 번호 >> ");
				sc.nextLine();
				String bno = sc.nextLine();
				System.out.print("◎◎ 도서명 >> ");
				String bname = sc.nextLine();
				System.out.print("◎◎ 도서가격 >> ");
				int price = sc.nextInt();
				System.out.print("◎◎ 출판사 >> ");
				sc.nextLine();
				String company = sc.nextLine();
				System.out.print("◎◎ 저자 >> ");
				String writer = sc.nextLine();
				
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer);
				bDao.BookUpdate(bDto);
			
			}else if (code == 3) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 삭제할 도서 번호를 입력해주세요.");
				System.out.print("◎◎ 도서 번호 >> ");
				sc.nextLine();
				String bno = sc.nextLine();
				bDao.BookDelete(bno);
				
			}else if (code == 4) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 현재 판매중인 도시 목록을 출력합니다.");
				bDao.BookSelect();
				
			}else if (code == 5) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 보고싶은 도서 이름을 입력해주세요.");
				System.out.print("◎◎ >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				
				bDao.BookSearch(bname);
				
			}else if (code == 6) {
				
			}else if (code == 7) {
				System.exit(0);
			}
		}
	}
}
