package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.JsonObject;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//요청시 입력한 값을 전달 받는다
		BoardVO vo = new BoardVO();
		
//		vo.setWriter(request.getParameter("writer"));
//		vo.setSubject(request.getParameter("subject"));
//		vo.setPassword(request.getParameter("password"));
//		vo.setContent(request.getParameter("content"));
//		vo.setMail(request.getParameter("mail"));
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		vo.setHit(0);
		vo.setWip(request.getRemoteAddr());
		
		//service객체 얻어온다
		BoardServiceInf service = BoardService.getInstance();
		
		//service객체의 메서드 호출 - 결과값 받는다
		int seq = service.insertBoard(vo);
		
		//json데이터 생성한다
		JsonObject jsonObj = new JsonObject();
		if (seq > 0)
			jsonObj.addProperty("flag", "OK");
		else
			jsonObj.addProperty("flag", "NO");
		
		//출력한다
		PrintWriter writer = response.getWriter();
		writer.write(jsonObj.toString());
		writer.close();
	}

}
