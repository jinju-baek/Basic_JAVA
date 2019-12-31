package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
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

	// 계좌 개설
	public void insertBank(String bname, String pw) { 
		sqlSession = sqlSessionFactory.openSession(true);// true = 자동커밋, 안해주면 sqlSession.commit();일일이 쳐줘야 함(insert,update,delete)
	
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			// sqlSession.commit();
			if(result > 0) {
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
	
	// 계좌 해지
	public void deleteBank(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			// "bno", bno
			// "pw", pw
			HashMap<String, Object> map = new HashMap<>(); 
			map.put("bno", bno);
			map.put("pw", pw);
			
			result = sqlSession.delete("deleteBank", map);
		
			
			if(result > 0) {
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
	
	// 계좌 입금
	public void plusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Integer> map = new HashMap<>(); // 제네릭 안에는 객체자료형밖에 못 옴 | Int >> Integer(Wrapper Class)
			map.put("bno", bno);
			map.put("money", money);
			map.put("flag", 1);
			result = sqlSession.update("changeMoney", map);
			
			
			if(result > 0) {
				System.out.println("■■ 현재 계좌 잔액은 " + balanceMoney(bno) + " 입니다.");
			} else {
				System.out.println("■■ 계좌입금에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	// 사용자 유무 확인
	public boolean checkUser(int bno, String pw) {
		boolean flag = true;
		sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("pw", pw);
			int result = sqlSession.selectOne("checkUser", map);
			if(result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}
	
	public void minusBank(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("bno", bno);
			map.put("money", money);
			map.put("flag", 0);
			int result = sqlSession.update("changeMoney", map);
			
			if(result > 0) {
				System.out.println("■■ " + money + "원 출금에 성공하였습니다. 현재 계좌 잔액은 "+ balanceMoney(bno) + "입니다.");
			} else {
				System.out.println("■■ 출금에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
		
	// 고객 조회
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
	
	// 계좌 금액 조회
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

	// 사용자 검색
	public void searchBank(String keyword) {

	}
	
	// 계좌 잔액 조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			money = sqlSession.selectOne("balanceMoney", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return money;
	}
	
	public void printQuery(ArrayList<BankDTO> list) {
		System.out.println("■■ 계좌번호\t예금주\t비밀번호\t잔액\t계좌개설일");
		for (BankDTO line : list) {
			System.out.println(line.getBno() + "\t" + line.getBname() + "\t" + line.getPw() + "\t" + line.getMoney() + "\t" + line.getRegdate());
		}
	}





}
