package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.JsonObject;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.member.vo.MemberVo;

@WebServlet("/MemberJoin")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//		mem_id=&mem_name=&mem_zip=&mem_add1=&mem_add2=&mem_pass=
		//요청시 전달되는 데이터를 받는다
		
		MemberVo vo = new MemberVo();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		//service객체 얻어오기
		MemberServiceInf service = MemberServiceImpl.getInstance();
		
		//메서드 호출 하기 - 결과값 받기
		String res = service.insertMember(vo);
		
		if (res != null)
			res = res + "님 가입성공";
		else
			res = vo.getMem_id() + "님 가입실패";
		
		
		//결과값으로 json데이터 생성
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("flag", res);
		
		response.getWriter().write(jsonObj.toString());
	}

}
