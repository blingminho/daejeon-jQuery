<%@page import="kr.or.ddit.bh.BhVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
	<%
	List<BhVo> list=(List<BhVo>)request.getAttribute("list");
	
	for (int i = 0; i < list.size(); i++) {
		BhVo vo = list.get(i);
		if(i!=0){
			out.print(",");
		}
%>
		{
		"id" : "<%=vo.getLprod_id() %>" ,
		"gu" : "<%=vo.getLprod_gu() %>" ,
		"nm" : "<%=vo.getLprod_nm() %>" 
		}

<%
	}	
	%>
]