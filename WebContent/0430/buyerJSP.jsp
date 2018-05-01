<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    [
<%
	List<BuyerVo> list = (List<BuyerVo>)request.getAttribute("buyerList");
	for(int i = 0; i < list.size(); i++){
		BuyerVo vo = list.get(i);
		if(i!=0){
			out.print(",");
		}
%>
		{
		"id" : "<%=vo.getBuyer_id()%>" ,
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

<%
	}

%>
    ]