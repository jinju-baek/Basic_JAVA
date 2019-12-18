package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BankDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;		
	int result = 0;

	public void bankInsert(String bname, String pw) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno, bname, pw) "
					   + "VALUES(seq_bank.nextVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, pw);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("등록 성공!!");
			} else {
				System.out.println("등록 실패!! 관리자에게 문의해주세요.");
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
	
	public void bankDep(int bno, int money) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "
					+ "SET money = money + ? "
					+ "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, bno);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("입금 성공!!");
			} else {
				System.out.println("입금 실패!! 관리자에게 문의해주세요");
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
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank";
			pstmt = conn.prepareStatement(sql);
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
