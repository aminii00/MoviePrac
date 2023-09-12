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
	int MAX_ROW = 5;
	int MAX_COL = 9;
	String[][] map = new String[MAX_ROW][MAX_COL];

	public void init(ServletConfig config) throws ServletException {
		moviesdao = new MoviesDao();
		reservationDao = new ReservationDao();
		reservation = new Reservation();
		System.out.println("MemberDAO init ������ ����");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		if (action == null || action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			Member member = new Member();
			member.setId(id);
			member.setPwd(pwd);
			Member member1 = moviesdao.memberSearch(member);
			if (member1 != null && member1.getId() != null) {
				session = request.getSession();
				session.setAttribute("isLogOn", true);
				session.setAttribute("memberInfo", member1);
				nextPage="/test01/cuslist.jsp";
			}else {
				nextPage="/test01/login.jsp";
			}
			    
		}else if (action.equals("/listMembers.do")) {
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
			Movie memInfo = moviesdao.findByMovieId(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test01/modMemberForm.jsp";
		}else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			Integer _id = Integer.parseInt(id);
			moviesdao.deleteMovie(_id);
			request.setAttribute("msg","deleted");
			nextPage= "/movie1/listMembers.do";
		}else if(action.equals("/movieticket.do")){  //��ȭ �����ϱ�
			List<Movie> membersList = moviesdao.printAllMovies();
			request.setAttribute("membersList", membersList);
			nextPage="/test01/moviereserlist.jsp";
		}else if(action.equals("/cusreser.do")) {  //��ȭ ���� 2
			String movieid = request.getParameter("id");
			System.out.println(movieid);
			Movie m = moviesdao.findByMovieId(movieid);
			System.out.println(m);
			request.setAttribute("m", m);
			session.setAttribute("m", m);
			nextPage="/test01/seat.jsp";
		}else if (action.equals("/rowcol.do")) {  // �¼�����
			String seat = request.getParameter("seat");
			Movie m = (Movie) session.getAttribute("m");
			Member member = (Member) session.getAttribute("memberInfo");
			Reservation res = new Reservation();
			res.setMovieid(m.getId());
			res.setMoviename(m.getTitle());
			res.setResid(member.getId());
			res.setSeat(seat);
			reservationDao.insertReser(res);
			nextPage="/test01/cuslist.jsp";
		}else if(action.equals("/movieCheck.do")) {
			Member member = (Member) session.getAttribute("memberInfo");
			String id = member.getId();
			List<Reservation> movieList = reservationDao.findByResId(id);
			request.setAttribute("movieList", movieList);
			nextPage="/test01/movieCheckList.jsp";
			
		}else {
			nextPage="/test01/login.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
