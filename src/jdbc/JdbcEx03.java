package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호: ");
		int num = sc.nextInt();
		System.out.print("이름: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이: ");
		int age = sc.nextInt();
		
		try { // 예외가 발생할 수도 있는 부분
			Connection conn = DBManager.getConnection();
			
			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql); // prepareStatement -> 값을 동적으로 바꿀 수 있음
			pstmt.setInt(1, num); // (물음표 순서, 값)
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			int result = pstmt.executeUpdate(); //자바가 DB에 값 저장하라고 명령
			if(result > 0) { // DB 호출이 끝나면 1. 성공 2. 실패 값을 가져옴
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
