package sec01.ex01;

public class Reservation {
	private String resid;
	private String seat;
	private String moviename;
	private String movieid;
	
	public Reservation() {
		
	}
	
    public Reservation (String seat, String moviename, String movieid) {
    	super();
    	this.seat = seat;
    	this.moviename = moviename;
    	this.movieid = movieid;
    }

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
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

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	
	public String toString() {
		return "Reservation [resid= " + resid + ", seat= " + seat + ", moviename= " + moviename +
				", movieid= " + movieid + "]";
	}
}
