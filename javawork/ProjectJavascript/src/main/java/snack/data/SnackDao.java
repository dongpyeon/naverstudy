package snack.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DbConnect;

public class SnackDao {
	DbConnect db = new DbConnect();
	//검색 결과 출력
			public List<SnackDto> getSearchName(String search)
			{
				List<SnackDto> list=new Vector<SnackDto>();
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String sql="select * from Snack where name like ? order by num";

				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, "%"+search.trim()+"%");
					rs=pstmt.executeQuery();

					while(rs.next())
					{
						SnackDto dto=new SnackDto();//반드시 while문 안에 선언
						dto.setNum(rs.getString("num"));
						dto.setName(rs.getString("name"));
						dto.setPrice(rs.getString("price"));
						dto.setMakedate(rs.getTimestamp("makedate"));
						dto.setBrand(rs.getString("brand"));
						dto.setPhoto(rs.getString("photo"));
						//list 에 추가
						list.add(dto);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(rs, pstmt, conn);
				}

				return list;
			}
		//전체 출력
		public List<SnackDto> getAllSnack()
		{
			List<SnackDto> list=new Vector<SnackDto>();
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from snack order by num";

			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next())
				{
					SnackDto dto=new SnackDto();//반드시 while문 안에 선언
					dto.setNum(rs.getString("num"));
					dto.setName(rs.getString("name"));
					dto.setPrice(rs.getString("price"));
					dto.setMakedate(rs.getTimestamp("makedate"));
					dto.setBrand(rs.getString("brand"));
					dto.setPhoto(rs.getString("photo"));
					//list 에 추가
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}

			return list;
		}

		//insert
		public void insertSnack(SnackDto dto)
		{
			String sql="insert into snack (name,price,brand,photo,makedate) values (?,?,?,?,now())";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;

			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getPrice());
				pstmt.setString(3, dto.getBrand());
				pstmt.setString(4, dto.getPhoto());
				//실행
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
		}

		//delete
		public void deleteSnack(String num)
		{
			String sql="delete from snack where num=?";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;

			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, num);
				//실행
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
		}


	
}
