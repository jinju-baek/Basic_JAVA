package problem.DDboard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.DBManager;
import jdbc.mybatis.SqlMapConfig;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	List<BoardDTO> list;

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	// 게시글 등록
	public void boardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
			int result = sqlSession.insert("boardInsert", map);
			if(result > 0) {
				System.out.println("▨▧ 게시글 등록에 성공하였습니다. ");
			}else {
				System.out.println("▨▧ 게시글 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}	
	}

	// 게시글 수정
	public void boardUpdate(int bno, String title, String content, String writer) {	
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
			int result = sqlSession.update("boardUpdate", map);
			if(result > 0) {
				System.out.println("▨▧ 게시글 수정에 성공하였습니다.");
			} else {
				System.out.println("▨▧ 게시글 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 게시글 삭제
	public void boardDelete(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			int result = sqlSession.delete("boardDelete", bno);
			if(result > 0) {
				System.out.println("▨▧ 게시글 삭제에 성공하였습니다.");
			} else {
				System.out.println("▨▧ 게시글 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 게시글 조회
	public void boardSelect() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSelect");
			System.out.println("번호\t제목\t내용\t작성자\t작성일");
			for(BoardDTO line : list) {
				System.out.println(line.getBno() + "\t" + line.getTitle() + "\t" + line.getContent() + "\t" 
			+ line.getWriter() + "\t" + line.getRegdate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 제목으로 게시글 검색 
	public void boardSearch(String title) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			list = sqlSession.selectList("boardSearch", title);
			System.out.println("번호\t제목\t내용\t작성자\t작성일");
			for(BoardDTO line : list) {
				System.out.println(line.getBno() + "\t" + line.getTitle() + "\t" + line.getContent() 
				+ "\t" + line.getWriter() + "\t" + line.getRegdate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	// 조회순으로 게시글 정렬
	public void boardSort() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSort");
			System.out.println("번호\t제목\t내용\t작성자\t조회수\t작성일");
			for(BoardDTO line : list) {
				System.out.println(line.getBno() + "\t" + line.getTitle() + "\t" + line.getContent() + "\t" + line.getWriter()
				 + "\t" + line.getViewcnt() + "\t" + line.getRegdate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardView(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			viewcntPlus(bno);
			list = sqlSession.selectList("boardView", bno);
			for(BoardDTO line : list) {
				System.out.println("게시글 번호 : " + line.getBno());
				System.out.println("제목 : " + line.getTitle());
				System.out.println("내용 : " + line.getContent());
				System.out.println("작성자 : " + line.getWriter());
				System.out.println("조회수 : " + line.getViewcnt());
				System.out.println("작성일 : " + line.getRegdate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void viewcntPlus(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			sqlSession.update("viewcntPlus");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
