package user.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.db.DbConnect;


public class UserDao {
	DbConnect db=new DbConnect();

	//insert
	public void insertUser(UserDto dto)
	{
		//		String sql="insert into board (writer,subject,content,photo,writeday)"
		//				+ " values (?,?,?,?,now())";

		String sql="insert into user (id,passwd) values (?,?)";

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());

			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//삭제
	public void deleteUser(String name)
	{
		String sql="delete from user where id=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,name);

			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public boolean checkUser(UserDto dto)
	{
		boolean check = false;
		String sql="select id from user where id=? and passwd=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPasswd());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return check;
	}
	
	public boolean checkId(UserDto dto)
	{
		boolean check = false;
		String sql="select id from user where id=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,dto.getId());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return check;
	}


}
