package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import db.DbConnect;

public class Today_Review {
	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	public int getMenu()
	{
		System.out.println("1.추가  2.삭제  3.수정  4.전체출력  5.검색  6.종료");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}

	//insert
	public void insertStudent()
	{
		System.out.println("과자 이름 입력");
		String name = sc.nextLine();
		
		System.out.println("과자 가격 입력");
//		String price = sc.nextLine();
		String tprice = sc.nextLine();
		int price = Integer.parseInt(tprice);
		
		System.out.println("과자 브랜드 입력");
		String brand = sc.nextLine();
		
		if(price>30000) {
			System.out.println("솔직히 좀 비싸지 않냐?");
			return;
		}
		String sql = "insert into snack values (null,?,?,now(),?)";
		
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
//			pstmt.setString(2, price);

			pstmt.setInt(2, price);
			pstmt.setString(3, brand);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//delete
	public void deleteStudent()
	{
		System.out.println("어떤 과자를 사실래요?");
		String name = sc.nextLine();
		
		
		String sql = "delete from snack where name like ?";
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//update
	public void updateStudent()
	{
		
	}
	
	//전체 출력
	public void selectAllStudent()
	{
		String sql = "select * from snack";
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				String num = rs.getString("num");
				String name = rs.getString("name");
				String tprice = rs.getString("price");
				int price = Integer.parseInt(tprice);
				String makedate = rs.getString("makedate");
				String brand = rs.getString("brand");
				
				System.out.println(num +"\t"+name +"\t"+price +"\t"+
						makedate +"\t"+brand +"\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//검색-번호 끝 4자리로 검색
	public void searchPhone()
	{
		System.out.println("어떤 브랜드를 찾으세요??");
		String searchn = sc.nextLine();
		
		String sql = "select * from snack where brand like ?";
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchn+"%");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Today_Review ex=new Today_Review();
		
		while(true)
		{
			System.out.println("-".repeat(40));
			int menu=ex.getMenu();
			System.out.println("-".repeat(40));
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:				
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}

	}

}