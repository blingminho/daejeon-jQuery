package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		//전체 글갯수 구하기
		int totalCount = service.listCount();
		
		//한페이지당 출력할 글갯수
		int perlist = 3;
		
		//한 페이지당 출력할 페이지의 갯수
		int perpage = 2;
		
		//전체 페이지 갯수
		int totalPage = (int) Math.ceil(totalCount / (double)perlist);
		
		//시작글번호와 끝글번호 (1페이지 : 1~3, 2페이지 : 4~6)
		int start = (cpage-1) * perlist + 1;		
		int end = start + perlist - 1;
		if(end > totalCount) end = totalCount;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		//시작 페이지와 끝페이지 (1화면 : 1,2 / 2화면 : 3,4 / 4화면 7)
		int startPage = ((cpage - 1) / perpage * perpage) + 1;
		int endPage = startPage + perpage - 1;
		if(endPage >  totalPage) endPage = totalPage;
		
		//결과값 받기
		List<BoardVO> list = service.selectAll(map);
		
		JsonObject jsonParentObj = new JsonObject();
		jsonParentObj.addProperty("startPage", startPage);
		jsonParentObj.addProperty("endPage", endPage);
		jsonParentObj.addProperty("totalPage", totalPage);
		
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
		
		jsonParentObj.add("list", jsonArray);
		
		response.getWriter().write(jsonParentObj.toString());
	}
}
