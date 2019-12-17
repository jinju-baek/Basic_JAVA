package problem.DDEnter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DateBase Access Object(DB작업)
public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<MemberDTO> list = new ArrayList<>();
	
	
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
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void memUpdate(MemberDTO mDto) { // 2. 아티스트 수정
		try {
			// 1. 드라이버 로드
			// 2. Connection
			conn = DBManager.getConnection();
			
			// 3. SQL작성(PreparedStatement)
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
			
			// 4. SQL실행
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦ " + mDto.getAname() + "아티스트의 정보를 수정하였습니다.");
			}else {
				System.out.println("▦▦ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
			// 5. Close(연결끊기)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public void memSelect() { // 4. 아티스트 조회
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter";
			pstmt = conn.prepareStatement(sql);
			
			// 4. SQL실행
			// ResultSet = SELECT문에 결과를 담음(DB전용)
			rs = pstmt.executeQuery(); // SELECT문
			
			while(rs.next()) { // 한 줄씩 읽다가 값이 있을경우 결과값을 true로 반환
				String ano = rs.getString("ano"); // ""안의 값은 DB의 컬럼명이랑 똑같이 써야 함
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
			}
			for(MemberDTO line : list) {
				System.out.println(line.toString());
			}
			// ResultSet은 DB관련객체
			// JAVA전용 ArrayList에 ResultSet에 데이터를 옮겨담는 작업이 필요
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void memSearch(String aname) { // 5. 아티스트 검색
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter "
					   + "WHERE aname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + aname + "%");
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("ano") + "\t" + rs.getString("aname") + "\t" + rs.getString("major") 
								+ "\t" + rs.getString("groupyn") + "\t" + rs.getString("groupnm") 
								+ "\t" + rs.getInt("sal") + "\t" + rs.getDate("regdate"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
