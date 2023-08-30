package sec01.ex01;

import java.io.IOException;
import java.util.List;

class MainMenu extends AbstractMenu{
	MoviesDao moviesDao = new MoviesDao();
	ReservationDao reservationDao = new ReservationDao();
	private static final MainMenu instance = new MainMenu(null);
	private static final String MAIN_MENU_TEXT = 
			        "1: ��ȭ �����ϱ�\n" +
				    "2: ���� Ȯ���ϱ�\n" +
				    "3: ���� ����ϱ�\n" +
				    "4: ������ �޴��� �̵�\n" +
				    "q: ����\n\n" +
				    "�޴��� �����ϼ���: ";
	
	private MainMenu (Menu prevMenu) {
		super(MAIN_MENU_TEXT, prevMenu);
	}
	public static MainMenu getInstance() {
		return instance;
	}
	public Menu next() {
		switch (scanner.nextLine()) {
		case "1" : 
			reserve();
			return this;
		case "2" : 
			checkReservation();
			return this;
		case "3" : 
			cancelReservation();
			return this;
		case "4" : 
			if(!checkAdminPassword()) {
				System.out.println(">> ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				return this;
			}
			AdminMenu adminMenu = AdminMenu.getInstance();
			adminMenu.setPrevMenu(this);
			return adminMenu;
		case "q" : 
			return prevmenu;
		default: return this;
		}
	}
	private boolean checkAdminPassword() {
		System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
		return "admin1234".equals(scanner.nextLine());
	}
	private void checkReservation() {
		System.out.print("���� �߱޹�ȣ�� �Է��ϼ���: ");
		try {
			Reservation r=
					reservationDao.findByResId(Integer.parseInt(scanner.nextLine()));
			if (r != null) {
				System.out.println(">> [Ȯ�� �Ϸ�]" + ", ���Ź߱޹�ȣ: " + r.getResid() + 
						", �¼� " + r.getSeat() + ", ��ȭ�̸�: " + r.getMoviename());
			}else {
				System.out.println(">> ���� ������ �����ϴ�.");
			}
		}catch(Exception e) {
			System.out.println(">> ���� ����¿� ������ ������ϴ�.");
		}
	}
	
	private void cancelReservation() {
		System.out.println("���� �߱޹�ȣ�� �Է��ϼ���: ");
		int cancel = Integer.parseInt(scanner.nextLine());
		boolean canceled = reservationDao.cancel(cancel);
		if(canceled != false) {
			System.out.printf("[��� �Ϸ�] %d�� ���Ű� ��ҵǾ����ϴ�.\n",  cancel);
		}else {
			System.out.println(">> ���� ������ �����ϴ�.");
		}
	}
	private void reserve() {
		try {
			List<Movie> movies = moviesDao.printAllMovies();
			for (int i = 0; i<movies.size(); i++) {
				System.out.printf("%s\n", movies.get(i).toString());
			}
			System.out.println("������ ��ȭ�߱޹�ȣ�� �Է��ϼ���: ");
			int movieid = Integer.parseInt(scanner.nextLine());
			Movie m = moviesDao.findByMovieId(movieid);
			System.out.println(m);
			List<Reservation> reservations = reservationDao.findById(m.getTitle());
			Seats seats = new Seats(reservations);
			seats.show();
			System.out.println("�¼��� �����ϼ���(��: E-9): ");
			String seatName = scanner.nextLine();
			Reservation r = new Reservation(seatName, m.getTitle(), m.getId());
			int _resid = reservationDao.save(r);
			System.out.println(">> ���Ű� �Ϸ�Ǿ����ϴ�.");
			System.out.printf(">> �߱޹�ȣ : %d\n", _resid);
		}catch(IOException e) {
			System.out.println(">> ���� ����¿� ������ ������ϴ�.");
		}catch(Exception e) {
			System.out.printf(">> ���ſ� �����Ͽ����ϴ�: %s\n" ,e.getMessage());
		}
	}
}
