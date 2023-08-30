package sec01.ex01;

import java.util.List;

public class AdminMenu extends AbstractMenu {
	MoviesDao moviesDao = new MoviesDao();
	private static final AdminMenu instance = new AdminMenu(null);
	private static final String ADMIN_MENU_TEXT = 
			"1: ��ȭ ����ϱ�\n" +
		    "2: ��ȭ ��Ϻ���\n" +
		    "3: ��ȭ �����ϱ�\n" +
		    "b: ���� �޴��� �̵�\n\n" +
		    "�޴��� �����ϼ���: ";

	public AdminMenu(Menu prevMenu) {
		super(ADMIN_MENU_TEXT, prevMenu);
	}
	
	public static AdminMenu getInstance() {
		return instance;
	}
	
	public Menu next() {
		switch (scanner.nextLine()) {
		case "1" :
			createMovie();
			return this;
		case "2" :
			printAllMovies();
			return this;
		case "3" :
			deleteMovie();
			return this;
		case "b" :
			return prevmenu;
	    default : 
	    	return this;
		}
	}

	
	private void createMovie() {
		System.out.print("����: ");
		String title = scanner.nextLine();
		System.out.print("�帣: ");
		String genre = scanner.nextLine();
        Movie movie = new Movie(title,genre);
        try {
        	int _id = moviesDao.save(movie);
        	System.out.println(">> ��ϵǾ����ϴ�. ��ȭ �߱� ��ȣ�� : " + _id + "�Դϴ�.");
        }catch(Exception e) {
        	System.out.println(">> �����Ͽ����ϴ�.");
        }
	}
	private void printAllMovies() {
		try {
			List<Movie> list = moviesDao.printAllMovies();
			for (int i = 0; i<list.size(); i++) {
				Movie movie = (Movie) list.get(i);
				System.out.println("����ȭ�߱޹�ȣ: " + movie.getId()+ ", ��ȭ����: " + movie.getTitle() +
						", ��ȭ �帣: " + movie.getGenre());
			}
		}catch(Exception e) {
			System.out.println("������ ���ٿ� �����Ͽ����ϴ�.");
		}
	}
	private void deleteMovie() {
		printAllMovies();  //��� ��ȭ ���
		System.out.println("������ ��ȭ�߱޹�ȣ�� �Է��ϼ���.: ");
		int movieid = Integer.parseInt(scanner.nextLine());
		try {
			boolean result = moviesDao.deleteMovie(movieid);
			System.out.println(">> ��ȭ �߱޹�ȣ : " + movieid + "�����Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}
}
