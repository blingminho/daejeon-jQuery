<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
{
<%
	BuyerVo vo = (BuyerVo)request.getAttribute("buyer");
%>
		"id" : "<%=vo.getBuyer_id()%>",
		"name" : "<%=vo.getBuyer_name() %>" ,
		"lgu" : "<%=vo.getBuyer_lgu() %>" ,
		"bank" : "<%=vo.getBuyer_bank() %>" ,
		"bankno" : "<%=vo.getBuyer_bankno() %>" ,
		"bankname" : "<%=vo.getBuyer_bankname() %>" ,
		"zip" : "<%=vo.getBuyer_zip() %>" ,
		"add1" : "<%=vo.getBuyer_add1() %>" ,
		"add2" : "<%=vo.getBuyer_add2() %>" ,
		"comtel" : "<%=vo.getBuyer_comtel() %>" ,
		"fax" : "<%=vo.getBuyer_fax() %>" ,
		"mail" : "<%=vo.getBuyer_mail() %>" 
}


	


    