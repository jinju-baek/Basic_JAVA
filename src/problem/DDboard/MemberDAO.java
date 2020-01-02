package problem.DDboard;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	// 로그인 기능
	public void login(String id, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		try {
			int count = sqlSession.selectOne("login", map);
			if(count > 0) {
				DDBoardMain.session = "YES";
				DDBoardMain.userid = id;
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 반갑습니다. " + id + "님");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			} else {
				System.out.println("▨▧ ID 또는 PW가 틀립니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 로그아웃 기능
	public void logout() {
		
	}
	
	// 회원 가입
	// 회원 수정
	// 회원 삭제
	// 회원 검색
	// 회원 조회
}
