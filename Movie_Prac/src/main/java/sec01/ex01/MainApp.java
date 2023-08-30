package sec01.ex01;

interface Menu {
	void print();
	Menu next();
}

public class MainApp {


	public static void main(String[] args) {
		System.out.println("���α׷��� �����մϴ�!");
		Menu menu = MainMenu.getInstance();
		while (menu != null) {
			menu.print();
			menu = menu.next();
		}
		System.out.println("���α׷��� ����˴ϴ�.");
	}
}

