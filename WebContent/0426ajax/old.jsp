<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String tel = request.getParameter("tel");
String addr = request.getParameter("addr");
%>
<br>
안녕하세요 반갑습니다 
<%=name %>님
<br>
당신의 전화번호는
<%=tel %>입니다.
<br>
당신의 주소는
<%=addr %>입니다