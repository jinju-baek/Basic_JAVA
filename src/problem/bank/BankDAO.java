package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;
import problem.common.DBManager;

public class BankDAO {
	// MyBatis 세팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
	
	List<BankDTO> list2;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;		
	int result = 0;

	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);// true = 자동커밋, 안해주면 sqlSession.commit();일일이 쳐줘야 함(insert,update,delete)
	
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			// sqlSession.commit();
			if(result == 1) {
				System.out.println("■■ " + bname + "님 신규계좌를 개설하였습니다.");
			} else {
				System.out.println("■■ 계좌개설에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteBank(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			result = sqlSession.delete("deleteBank", bDto);
			
			if(result == 1) {
				System.out.println("■■ " + bno + "계좌를 삭제하였습니다.");
			}else {
				System.out.println("■■ 계좌삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public void updateMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BankDTO bDto = new BankDTO(bno, money);
			result = sqlSession.update("updateMoney", bDto);
			
			if(result == 1) {
				System.out.println("■■ " + bno + "계좌에 " + money + "원을 입금하였습니다.");
			} else {
				System.out.println("■■ 계좌입금에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}


	public int bankCheck(int bno, String pw) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank "
					+ "WHERE bno = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result++; 
			}
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
		return result;
	}
	
	public int moneyCheck(int bno, int dept) {
		int money = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT money FROM tbl_bank "
					+ "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				money = rs.getInt("money");
			}
			if(money >= dept) {
				result = 1;
			} else {
				result = 0;
			}
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
		return result;
	}
	
	public void bankWithDraw(int bno, int dept) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "
					   + "SET money = money - ? "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept);
			pstmt.setInt(2, bno);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println(dept+"원 출금되셨습니다.");
			} else {
				System.out.println("출금 실패!! 관리자에게 문의해주세요.");
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
	
	public void bankSelect() {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			list2 = sqlSession.selectList("selBank"); 
			// selectList = 조회값이 여러건일 경우 사용
			// selectOne = 조회값이 한건일경우 사용
			// update, delete, insert
			for(BankDTO line : list2) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				sqlSession.close();
		}
	}
	
	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto);
			
			if(bDto == null) {
				System.out.println("■■ 존재하지 않는 계좌이거나 비밀번호가 틀렸습니다.");
				return;
			}else {
				System.out.println("■■ " + bno + "계좌의 총 금액은 " + bDto.getMoney()+ "입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void bankSearch(String keyword) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank "
					   + "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");
				
				bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
			}
			System.out.println("\"" + keyword + "\"으로 검색한 결과 "+list.size()+"건이 나왔습니다.");
			printQuery(list);
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
	
	public void printQuery(ArrayList<BankDTO> list) {
		System.out.println("■■ 계좌번호\t예금주\t비밀번호\t잔액\t계좌개설일");
		for (BankDTO line : list) {
			System.out.println(line.getBno() + "\t" + line.getBname() + "\t" + line.getPw() + "\t" + line.getMoney() + "\t" + line.getRegdate());
		}
	}



}
