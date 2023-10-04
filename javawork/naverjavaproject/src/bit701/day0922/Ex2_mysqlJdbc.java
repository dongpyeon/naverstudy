package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_mysqlJdbc {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	public Ex2_mysqlJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mysql 드라이버 실패"+e.getMessage());
		}
	}
	
	public void sawonAllDatas()
	{
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null; // select 일 경우에만 필요
		
		String sql = "select * from sawon;";

		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); // select 일 경우는 무조건 executeQuery
			int total = 0;
			
			System.out.println("숫자 \t 이름\t 점수\t 성별\t 부서");
			while(rs.next()) 
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				
				total+=score;
				
				System.out.println(num+"\t"+name+"\t"+score+"\t"+gender+"\t"
						+buseo+"\n");
			}
			System.out.println("총점은 :"+total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 연결 실패"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_mysqlJdbc ex = new Ex2_mysqlJdbc();
		ex.sawonAllDatas();
	}

}
