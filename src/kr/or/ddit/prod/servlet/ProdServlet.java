package kr.or.ddit.prod.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.prod.vo.ProdVo;

/**
 * Servlet implementation class lprodServlet
 */
@WebServlet("/prodServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdServiceInf service;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		
		service = ProdServiceImpl.getInstance();
		
		List<ProdVo> list =null;
		
		String lprod_gu = request.getParameter("lprod_gu");
		
		try {
			list = service.listProdNames(lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		JsonArray jsonArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("prod_id", list.get(i).getProd_id());
			obj.addProperty("prod_name", list.get(i).getProd_name());
			jsonArray.add(obj);
		}
		
		response.getWriter().write(jsonArray.toString());
		*/
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < list.size(); i++) {
			if (i != 0)
				sb.append(",");
			sb.append("{");
			sb.append("\"prod_id\" : " + "\"" + list.get(i).getProd_id() + "\"" + ",");
			sb.append("\"prod_name\" : " + "\"" + list.get(i).getProd_name() + "\"");
			sb.append("}");
		}
		sb.append("]");
		try {
			response.getWriter().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ProdVo prodVO = null;
		try {
			prodVO = service.detailProd(request.getParameter("prod_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		JsonObject jsonObj = new JsonObject();
		
		jsonObj.addProperty("prod_id", prodVO.getProd_id());
		jsonObj.addProperty("prod_name", prodVO.getProd_name());
		jsonObj.addProperty("prod_lgu", prodVO.getProd_lgu());
		jsonObj.addProperty("prod_buyer", prodVO.getProd_buyer());
		jsonObj.addProperty("prod_cost", prodVO.getProd_cost());
		jsonObj.addProperty("prod_price", prodVO.getProd_price());
		jsonObj.addProperty("prod_sale", prodVO.getProd_sale());
		jsonObj.addProperty("prod_outline", prodVO.getProd_outline());
		jsonObj.addProperty("prod_detail", prodVO.getProd_detail());
		jsonObj.addProperty("prod_img", prodVO.getProd_img());
		jsonObj.addProperty("prod_totalstock", prodVO.getProd_totalstock());
		jsonObj.addProperty("prod_insdate", prodVO.getProd_insdate());
		jsonObj.addProperty("prod_properstock", prodVO.getProd_properstock());
		jsonObj.addProperty("prod_size", prodVO.getProd_size());
		jsonObj.addProperty("prod_color", prodVO.getProd_color());
		jsonObj.addProperty("prod_delivery", prodVO.getProd_delivery());
		jsonObj.addProperty("prod_unit", prodVO.getProd_unit());
		jsonObj.addProperty("prod_qtyin", prodVO.getProd_qtyin());
		jsonObj.addProperty("prod_qtysale", prodVO.getProd_qtysale());
		jsonObj.addProperty("prod_mileage", prodVO.getProd_mileage());
		
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
