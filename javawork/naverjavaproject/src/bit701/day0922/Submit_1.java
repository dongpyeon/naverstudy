package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Submit_1 {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	public Submit_1() {
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
	
	public void showAllData(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null; // select 일 경우에만 필요
		
		String sql ="select buseo,count(*) count,max(score) scoremax, min(score) minscore, avg(score) avgscore from sawon group by buseo;";
		
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); // select 일 경우는 무조건 executeQuery
			
			System.out.println("부서\t카운트\t최고점\t최하점\t 평균");
			
			while(rs.next())
			{
				String buseo = rs.getString("buseo");
				String count = rs.getString("count");
				String scoremax = rs.getString("scoremax");
				String minscore = rs.getString("minscore");
				double avgscore = rs.getDouble("avgscore");
				
				System.out.println(buseo+"\t"+count+"\t"+scoremax+"\t"+minscore+"\t"+avgscore);
			}
			
			//System.out.println("성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("실패"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Submit_1 sb = new Submit_1();
		sb.showAllData();

	}

}
