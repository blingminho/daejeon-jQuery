package kr.or.ddit.lprod.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;
import kr.or.ddit.lprod.vo.LprodVo;
import kr.or.ddit.member.service.MemberServiceInf;

/**
 * Servlet implementation class lprodServlet
 */
@WebServlet("/lprodServlet")
public class lprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lprodServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LprodServiceInf service = LprodService.getInstance();
		List<LprodVo> list =null;
		try {
		list = service.getLprodAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("0430/list.jsp");
		rd.forward(request, response);
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
