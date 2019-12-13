package problem.DDEnter;

import java.sql.Connection;
import java.sql.PreparedStatement;

// DateBase Access Object(DB작업)
public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	public void memInsert(MemberDTO mDto) { // 1. 아티스트 등록
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
					   + "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▦▦ 등록에 성공하였습니다.");
			} else {
				System.out.println("▦▦ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void memUpdate(MemberDTO mDto) { // 2. 아티스트 수정
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter "
					   + "SET aname = ?, "
					   + "    major = ?, "
					   + "	  groupyn = ?, "
					   + "    groupnm = ?, "
					   + "    sal = ? "
					   + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦ 수정에 성공하였습니다.");
			}else {
				System.out.println("▦▦ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void memDelete(String ano) { // 3. 아티스트 삭제

		try {
			// 1. 드라이버 로드, 2. DB 연결
			conn = DBManager.getConnection();
			// 3. SQL문 작성(PrepareStatement 방식)
			String sql = "DELETE FROM tbl_enter WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			// 3. 1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4.SQL문 실행
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("▦▦ " + ano + "-> 아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▦▦ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public void memSelect() { // 4. 아티스트 조회
	}

	public void memSearch() { // 5. 아티스트 검색
	}
}
