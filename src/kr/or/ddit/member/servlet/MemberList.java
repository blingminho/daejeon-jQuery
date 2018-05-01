package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.member.vo.MemberVo;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 데이터를 전송받는다 
		MemberServiceInf service = new MemberServiceImpl();
		
		//db의 member테이블에서 전체 데이터를 select
		List<MemberVo> list = service.getMemberAll();
		
		//list결과를 가지고 json데이터를 생성해서 클라이언트의 응답으로 보내준다
		//json데이터 생성은 jsp에 위임
		
		//jsp 위임방법은 forwar.request객체에  list결과를 저장
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("0427_ibatis_member/list.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
