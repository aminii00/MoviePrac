package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
	List<Reservation> reservationlist = new ArrayList();
	private Connection conn;
	
	public ReservationDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf-8",
					"root",
					"1234"
				);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Reservation> findById(String moviename){
		Reservation reservation = new Reservation();
		try {
			String sql = "select resid, seat, moviename, movieid from reservation where moviename=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, moviename);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				reservation.setResid(rs.getInt("resid"));
				reservation.setSeat(rs.getString("seat"));
				reservation.setMoviename(rs.getString("moviename"));
				reservation.setMovieid(rs.getInt("movieid"));
				reservationlist.add(reservation);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservationlist;
	}
	public Reservation findByResId(int parseInt) {
		Reservation reservation = new Reservation();
		try {
			String sql = "select resid, seat, moviename, movieid from reservation where resid = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				reservation.setResid(rs.getInt("resid"));
				reservation.setSeat(rs.getString("seat"));
				reservation.setMoviename(rs.getString("moviename"));
				reservation.setMovieid(rs.getInt("movieid"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}
	
	public int save (Reservation r) {
		int _resid = (int)(Math.random()*100000)+1;
		try {
			String sql = "insert into reservation (resid, seat, moviename, movieid) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _resid);
			pstmt.setString(2, r.getSeat());
			pstmt.setString(3, r.getMoviename());
			pstmt.setInt(4, r.getMovieid());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return _resid;
	}
	
	public boolean cancel (int cancel) {
		try {
			String sql = "delete from reservation where resid =? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cancel);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}


