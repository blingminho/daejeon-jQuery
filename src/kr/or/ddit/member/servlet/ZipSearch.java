package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.ziptb.vo.ZipVo;

@WebServlet("/ZipSearch")
public class ZipSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 및 응답의 인코딩을 UTF-8로 설정(get은 안해도됨, post는 해야함)
//		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//요청시 전달되는 데이터를 받는다
		String dong = request.getParameter("dong");
		
		//service객체 얻어오기
		MemberServiceInf service = MemberServiceImpl.getInstance();
		
		//메서드 호출 하기 - 결과값 받기
		List<ZipVo> list = service.zipSearch(dong);
		
		//결과값을 가지고 json데이터 생성
		JsonArray jsonArray = new JsonArray();
		for (ZipVo vo : list) {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("zipcode", vo.getZipcode());
			jsonObj.addProperty("sido", vo.getSido() == null ? "" : vo.getSido());
			jsonObj.addProperty("gugun", vo.getGugun() == null ? "" : vo.getGugun());
			jsonObj.addProperty("dong", vo.getDong() == null ? "" : vo.getDong());
			jsonObj.addProperty("bunji", vo.getBunji() == null ? "" : vo.getBunji());
			
			jsonArray.add(jsonObj);
		}
		
		//json데이터 출력
		response.getWriter().write(jsonArray.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
