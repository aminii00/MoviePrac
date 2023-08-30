package sec01.ex01;

public class ReservationVO {
	private int resid;
	private String seat;
	private String moviename;
	private int movieid;
	
	public ReservationVO() {
		
	}
	
    public ReservationVO (String seat, String moviename, int movieid) {
    	super();
    	this.seat = seat;
    	this.moviename = moviename;
    	this.movieid = movieid;
    }

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
}
