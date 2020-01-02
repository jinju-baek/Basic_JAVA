package problem.DDboard;

import java.util.Scanner;

public class DDBoardMain {
	static String session = "NO";
	static String userid = "";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO(); // 게시글 관련 기능
		MemberDAO mDao = new MemberDAO(); // 회원 관련 기능
		int code = 0; // 사용자가 선택한 프로그램 번호

		while (true) {
			System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
			System.out.println("▨▧ 더블디 게시판");
			System.out.println("☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜");
			bDao.boardSelect();
			System.out.println("☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞");
			System.out.println("▨▧ 1. 회원 로그인");
			System.out.println("▨▧ 2. 게시글 등록");
			System.out.println("▨▧ 3. 게시글 수정");
			System.out.println("▨▧ 4. 게시글 삭제");
			System.out.println("▨▧ 5. 게시글 조회");
			System.out.println("▨▧ 6. 게시글 검색");
			System.out.println("▨▧ 7. 게시글 정렬");
			System.out.println("▨▧ 8. 상세 게시글");
			System.out.println("▨▧ 9. 만든이");
			System.out.println("▨▧ 10. 게시글 종료");
			if(session.equals("YES")) {
				System.out.println("▨▧ \"" + DDBoardMain.userid + "\"님 재방문을 환영합니다.");
			}
			System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");

			
			while (true) {
				System.out.print("▨▧ 번호 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 10) {
					break;
				} else {
					System.out.println("▨▧ 1 ~ 10 중 다시 입력해주세요.");
					continue;
				}
			}
			if(code == 1) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ 로그인 정보를 입력해주세요");
				System.out.print("▨▧ 아이디 >> ");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("▨▧ 비밀번호 >> ");
				String pw = sc.nextLine();
				
				mDao.login(id, pw);
				
			}else if(code == 2) {
				if(session.equals("NO")) {
					System.out.println("▨▧ 로그인이 필요한 기능입니다.");
					continue;
				} 
					System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
					System.out.println("▨▧ 등록하실 정보를 입력해주세요.");
					System.out.print("▨▧ 제목 >> ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("▨▧ 내용 >> ");
					String content = sc.nextLine();
					String writer = userid;
					
					bDao.boardInsert(title, content, writer);
					
			}else if(code == 3) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ 수정하실 게시글의 번호를 입력해주세요.");
				System.out.print("▨▧ 번호 >> ");
				int bno = sc.nextInt();
				String writer = bDao.getWriter(bno);
				
				if(!(writer.equals(userid))) {
					System.out.println("▨▧ 게시글 수정 권한이 없습니다.");
					continue;
				}
					System.out.println("▨▧ 수정할 정보를 입력해주세요.");
					System.out.print("▨▧ 제목 >> ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("▨▧ 내용 >> ");
					String content = sc.nextLine();
					
					bDao.boardUpdate(bno, title, content, writer);
				
			}else if(code == 4) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ 삭제하실 게시글의 번호를 입력해주세요.");
				System.out.print("▨▧ 번호 >> ");
				int bno = sc.nextInt();
				
				String writer = bDao.getWriter(bno);
				
				if(!(writer.equals(userid))) {
					System.out.println("▨▧ 게시글 삭제 권한이 없습니다.");
					continue;
				}
					bDao.boardDelete(bno);
				
			}else if(code == 5) {
				bDao.boardSelect();
				
			}else if(code == 6) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ 검색하실 글의 제목을 입력해주세요." );
				System.out.print("▨▧ 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				bDao.boardSearch(title);
				
			}else if(code == 7) {
				bDao.boardSort();
				
			}else if(code == 8) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ 보실 게시글의 번호를 입력해주세요");
				System.out.print("▨▧ 번호 >> ");
				int bno = sc.nextInt();
				bDao.boardView(bno);
				
			}else if(code == 9) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ Name : DD BOARD PROGRAM");
				System.out.println("▨▧ Version : 1.7");
				System.out.println("▨▧ Use : JAVA, ORACLE");
				System.out.println("▨▧ Date : 2019.12.17");
				System.out.println("▨▧ made by daram2");
				System.out.println("▨▧ whitepearl0926@naver.com");
				
			}else if(code == 10) {
				System.out.println("▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧▨▧");
				System.out.println("▨▧ [프로그램 종료]");
				System.exit(0);
			}
		}
	}
}
