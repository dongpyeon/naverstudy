package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db = new DbConnect();
	
	public void sawonDelete()
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원명 입력");
		String name = sc.nextLine();
		
		String sql = "delete from sawon where name='"+name+"'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n =stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println(name+"사원은 없습니다");
			else
				System.out.println(n+"명의"+name+"사원이 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("삭제 오류"+e.getMessage());
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
		//사원명 입력후 해당 사원 삭제
		//결과값이 0이면 xxx사원은 없습니다
		//				n이면 총 n명의 xxx사원정보를 삭제했습니다.
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex = new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
