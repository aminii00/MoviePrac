package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/movie001/*")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDAO movieDAO;
	ReservationDAO reservationDAO;
	ReservationVO reservationVO;

	public void init(ServletConfig config) throws ServletException {
		movieDAO = new MovieDAO();
		reservationDAO= new ReservationDAO();
		reservationVO = new ReservationVO();
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
		
		if (action == null || action.equals("/listMembers.do")) { // 관리자모드_영화목록
			List<MovieVO> membersList = movieDAO.printAllMovies();
			request.setAttribute("membersList", membersList);
			nextPage="/movie/movieresult.jsp";
			
		}else if(action.equals("/delMember.do")) { // 관_영화 삭제
			String id = request.getParameter("id");
			Integer _id = Integer.parseInt(id);
			movieDAO.deleteMovie(_id);
			request.setAttribute("msg","deleted");
			nextPage= "/movie001/listMembers.do";	
		
		} else if (action.equals("/MemberForm.do")) { // 관_영화 삽입
			nextPage="/movie/MovieInfo.jsp";
		}else if (action.equals("/addMember.do")){
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			MovieVO memberVO = new MovieVO(title,genre);
			movieDAO.save(memberVO);
			nextPage = "/movie001/listMembers.do";
			
			
		}else if(action.equals("/movieticket.do")){  //영화 예매하기_선택
			List<MovieVO> membersList = movieDAO.printAllMovies();
			request.setAttribute("membersList", membersList);
			nextPage="/movie/movielist.jsp";	
		}else if(action.equals("/cusreser.do")) {  //영화 예매 2
			String movieid = request.getParameter("id");
			Integer _id = Integer.parseInt(movieid);
			System.out.println(_id);
			MovieVO m = movieDAO.findByMovieId(_id);
			System.out.println(m);
			List<ReservationVO> reservations = reservationDAO.findById(m.getTitle());
			request.setAttribute("reservations", reservations);
			nextPage="/test01/seat.jsp";
			
			
		}else {
			System.out.println("로그인 페이지");
			nextPage="/movie/login.jsp";
		}
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
