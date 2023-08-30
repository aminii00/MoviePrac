package sec01.ex01;

public class Movie {
	private int id;
	private String title;
	private String genre;
	
	public Movie(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}
	public Movie() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [��ȭ�߱޹�ȣ = " + id + " , ��ȭ����= " + title + " , �帣= " + genre + "]";
	}
}
