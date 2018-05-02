package kr.or.ddit.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemberServiceInf;

@WebServlet("/IdSearch")
public class IdSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//요청시 파라미터값을 가져온다
		String sid = request.getParameter("id");
		
		//service객체
		MemberServiceInf service = MemberServiceImpl.getInstance();
		
		//메서드호출
		String res = service.idCheck(sid);
		if (res == null) {
			response.getWriter().write("{}");
			return;
		}
		
		//json데이터 생성
		String jsonStr = "{\"mem_id\":\"" + res + "\"}";
		response.getWriter().write(jsonStr);
		
	}

}
