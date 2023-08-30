package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/movie1/*")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MoviesDao moviesdao;
	ReservationDao reservationDao;
	Reservation reservation;
	int MAX_ROW=5;
	int MAX_COL=9;
	String[][] map = new String[MAX_ROW][MAX_COL];

	public void init(ServletConfig config) throws ServletException {
		moviesdao = new MoviesDao();
		reservationDao= new ReservationDao();
		reservation = new Reservation();
		System.out.println("MemberDAO init 생성자 생성");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("action : " + action);
		if (action == null || action.equals("/listMembers.do")) {
			List<Movie> membersList = moviesdao.printAllMovies();
			request.setAttribute("membersList", membersList);
			nextPage="/test01/movieresult.jsp";
		}else if (action.equals("/addMember.do")){
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			Movie memberVO = new Movie(title,genre);
			moviesdao.save(memberVO);
			nextPage = "/movie1/listMembers.do";
		} else if (action.equals("/MemberForm.do")) {
			nextPage="/test01/MovieInfo.jsp";
			
		}else if(action.equals("/modMemberForm.do")) {
			String id =request.getParameter("id");
			Integer _id = Integer.parseInt(id);
			Movie memInfo = moviesdao.findByMovieId(_id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test01/modMemberForm.jsp";

		}else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			Integer _id = Integer.parseInt(id);
			moviesdao.deleteMovie(_id);
			request.setAttribute("msg","deleted");
			nextPage= "/movie1/listMembers.do";
		}else if(action.equals("/cuslist.do")) {  //로그인 submit
			nextPage= "/test01/cuslist.jsp";
		}else if(action.equals("/movieticket.do")){  //영화 예매하기
			List<Movie> membersList = moviesdao.printAllMovies();
			request.setAttribute("membersList", membersList);
			nextPage="/test01/moviereserlist.jsp";
		}else if(action.equals("/cusreser.do")) {  //영화 예매 2
			String movieid = request.getParameter("id");
			Integer _id = Integer.parseInt(movieid);
			System.out.println(_id);
			Movie m = moviesdao.findByMovieId(_id);
			System.out.println(m);
			List<Reservation> reservations = reservationDao.findById(m.getTitle());
			request.setAttribute("reservations", reservations);
			nextPage="/test01/seat.jsp";
		}else if (action.equals("/moviecheck.do")) {
			String num = request.getParameter("num");
			int _num = Integer.parseInt(num);
			Reservation r=reservationDao.findByResId(_num);
			request.setAttribute("r", r);
			nextPage = "/test01/reservationresult.jsp";
		}else if (action.equals("/rowcol.do")) {  // 좌석선택
			String row = request.getParameter("row");
			String col = request.getParameter("col");
			String seatName = row + "-" +col;
			char[] temp = seatName.toCharArray(); // 좌석 명을 문자 배열로 변환
			int row_ = temp[0] - 'A';
			int col_ = temp[2] - '1';
			if("x".equals(map[row_][col_])) {
				throw new Exception ("이미 예매된 좌석입니다..");
			}
			map[row_][col_] = "x";
			// Reservation r = new Reservation(seatName, m.getTitle(), m.getId());
			//int _resid = reservationDao.save(r);
			//Reservation r = reservationDao.save(reservation);
		}else {
			nextPage="/test01/login.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
