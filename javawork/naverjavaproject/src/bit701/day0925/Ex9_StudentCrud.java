package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {
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
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("혈액형을 입력하세요");
		String blood = sc.nextLine().toUpperCase();
		
		System.out.println("폰번호입력");
		String phone = sc.nextLine();
		
		
		String sql = "insert into student (name, blood, phone, writeday) values (?,?,?,now())";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			
			pstmt.execute();
			System.out.println("학생을 추가하였습니다.");

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
		System.out.println("삭제할 이름을 입력하세요");
		String name = sc.nextLine();
		String sql = "delete from student where name=?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.execute();
			System.out.println("학생을 삭제하였습니다.");

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
		System.out.println("수정할 번호를 입력하세요");
		String no = sc.nextLine();
		
		System.out.println("수정할 이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("혈액형을 입력하세요");
		String blood = sc.nextLine().toUpperCase();
		
		System.out.println("폰번호입력");
		String phone = sc.nextLine();
		
		
		String sql = "update student set name=?, blood=?, phone=? where num=?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.setString(4, no);
			
			pstmt.execute();
			System.out.println("학생을 수정했습니다..");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체 출력
	public void selectAllStudent()
	{
		String sql = "select * from student order by num";
		
		Connection conn= db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				String writeday = rs.getString("writeday");

				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+writeday);
				
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
		

		System.out.println("뒷번호 입력");
		String searchPhone = sc.nextLine();
		String sql = "select * from student where phone like ?";
		
		Connection conn= db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchPhone);
			rs=pstmt.executeQuery();
			
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				String writeday = rs.getString("writeday");

				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+writeday);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex=new Ex9_StudentCrud();
		
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