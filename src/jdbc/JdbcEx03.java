package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호:");
		int num = sc.nextInt();
		System.out.print("이름:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이:");
		int age = sc.nextInt();
		
		try { 
		    Connection conn = DBManager.getConnection();
		    
		    String sql = "INSERT INTO tbl_study VALUES(?,?,?)"; 
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, num);
		    pstmt.setString(2, name);
		    pstmt.setInt(3, age);
		    
		    int result = pstmt.executeUpdate();
		    if(result > 0) {
		    	System.out.println("등록성공");
		    } else {
		    	System.out.println("등록실패");
		    }
		    
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
