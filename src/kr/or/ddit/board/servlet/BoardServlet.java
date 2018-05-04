package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//요청시 전달되는 데이터값을 받는다 = page번호
		int cpage = Integer.valueOf(request.getParameter("cpage"));
		
		
		service = BoardService.getInstance();
		
		List<BoardVO> list = service.selectAll();
		//전체 글갯수 구하기
		int listSize = list.size();
		
		//한페이지당 출력할 글갯수
		int perlist = 3;
		
		//한 페이지당 출력할 페이지의 갯수
		int perpage = 2;
		
		//전체 페이지 갯수
		
		
		
		JsonArray jsonArray = new JsonArray();
		
		for (BoardVO boardVO : list) {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("seq", boardVO.getSeq());
			jsonObj.addProperty("subject", boardVO.getSubject());
			jsonObj.addProperty("writer", boardVO.getWriter());
			jsonObj.addProperty("mail", boardVO.getMail());
			jsonObj.addProperty("password", boardVO.getPassword());
			jsonObj.addProperty("content", boardVO.getContent());
			jsonObj.addProperty("hit", boardVO.getHit());
			jsonArray.add(jsonObj);
		}
		
		
		response.getWriter().write(jsonArray.toString());
	}
}
