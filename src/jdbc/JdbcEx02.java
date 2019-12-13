package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcEx02 {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "java";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection(url, user, password);
		    
		    String sql = "INSERT INTO tbl_study VALUES(?,?,?)";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, 7);
		    pstmt.setString(2, "운이");
		    pstmt.setInt(3, 22);
		    
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
