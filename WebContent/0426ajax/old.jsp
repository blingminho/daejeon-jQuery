<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String addr = request.getParameter("addr");
%>

안녕하세요. 반갑습니다<%=name%>님<br>
당신의 전화번호는 <%=tel%><br>
주소는 <%=addr%> 입니다.