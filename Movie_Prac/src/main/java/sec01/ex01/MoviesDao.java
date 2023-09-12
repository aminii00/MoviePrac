package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MoviesDao {
	
	public Connection conn;
	
	public MoviesDao() {
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
	
	public Member memberSearch(Member member) {
		Member member1 = new Member();
		try {
			String sql = "select id, pwd from member where id=? and pwd=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member1.setId(rs.getString("id"));
				member1.setPwd(rs.getString("pwd"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return member1;
	}
	
	
	public List printAllMovies() {
		List<Movie> movielist = new ArrayList();
		try {
			
			System.out.println("gd");
			String sql = "select id, title, genre from movie order by id desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getString("id"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre(rs.getString("genre"));
				movielist.add(movie);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movielist;
	}
	public Movie findByMovieId(String _movie) {
		Movie movie = new Movie();
		try {
			String sql = "select id, title, genre from movie where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _movie);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				movie.setId(rs.getString("id"));
			    movie.setTitle(rs.getString("title"));
			    movie.setGenre(rs.getString("genre"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movie;
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
	
	public int save( Movie movie ) {
		System.out.print(movie.getTitle());
		int _id =(int)(Math.random()*10000)+1;
		try {
			String sql = "insert into movie (id,title,genre) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _id);
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3,movie.getGenre());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return _id;
	}
}
