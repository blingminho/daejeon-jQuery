<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
[
<%
	List<MemberVo> list = (List<MemberVo>) request.getAttribute("list");

	for (int i = 0; i < list.size(); i++) {
		MemberVo vo = list.get(i);
		if(i!=0){
			out.print(",");
		}
%>

	{
		"id" : "<%=vo.getMem_id() %>" ,
		"name" : "<%=vo.getMem_nama() %>" ,
		"hp" : "<%=vo.getMem_hp() %>" ,
		"mail" : "<%=vo.getMem_mail()%>" ,
		"addr1" : "<%=vo.getMem_add1()%>" 
	}

<%
	}
%>
]
