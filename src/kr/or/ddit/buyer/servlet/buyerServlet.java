package kr.or.ddit.buyer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceInf;
import kr.or.ddit.buyer.vo.BuyerVo;

/**
 * Servlet implementation class buyerServlet
 */
@WebServlet("/buyerServlet")
public class buyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerServiceInf service = BuyerService.getInstance();
		List<BuyerVo> buyerList = service.listBuyerNames();
		
		//json data 만들기 jsp로 위임
		request.setAttribute("buyerList", buyerList);
		
		RequestDispatcher rd = request.getRequestDispatcher("0430/buyerJSP.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerServiceInf service = BuyerService.getInstance();
		String buyer_id = (String) request.getParameter("ser");
		BuyerVo buyer = service.getBuyerDetail(buyer_id);
		//json data 만들기 jsp로 위임
		System.out.println("서블릿"+buyer);
		request.setAttribute("buyer", buyer);
		RequestDispatcher rd = request.getRequestDispatcher("0430/buyerVo.jsp");
		rd.forward(request, response);
	}

}
