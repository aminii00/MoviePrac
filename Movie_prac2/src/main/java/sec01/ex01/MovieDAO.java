package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	public Connection conn;
	
	public MovieDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf-8",
					"root",
					"1234"
					);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List printAllMovies() {
		List<MovieVO> movielist = new ArrayList();
		try {
			
			System.out.println("gd");
			String sql = "select id, title, genre from movie order by id desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieVO movieVO = new MovieVO();
				movieVO.setId(rs.getInt("id"));
				movieVO.setTitle(rs.getString("title"));
				movieVO.setGenre(rs.getString("genre"));
				movielist.add(movieVO);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movielist;
	}
	public MovieVO findByMovieId(int _movie) {
		MovieVO movieVO = new MovieVO();
		try {
			String sql = "select id, title, genre from movie where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _movie);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				movieVO.setId(rs.getInt("id"));
				movieVO.setTitle(rs.getString("title"));
				movieVO.setGenre(rs.getString("genre"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movieVO;
	}
	
	public boolean deleteMovie(int _movie) {
		try {
			String sql = "delete from movie where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _movie);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public int save( MovieVO movieVO ) {
		System.out.print(movieVO.getTitle());
		int _id =(int)(Math.random()*10000)+1;
		try {
			String sql = "insert into movie (id,title,genre) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _id);
			pstmt.setString(2, movieVO.getTitle());
			pstmt.setString(3,movieVO.getGenre());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return _id;
	}
}
