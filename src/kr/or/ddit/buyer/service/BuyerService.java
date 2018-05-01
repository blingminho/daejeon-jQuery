package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDao;
import kr.or.ddit.buyer.dao.BuyerDaoInf;
import kr.or.ddit.buyer.vo.BuyerVo;

public class BuyerService implements BuyerServiceInf {

	
	BuyerDaoInf dao = BuyerDao.getInstanceDao();
	
	private static BuyerServiceInf service = new BuyerService();
	
	public static BuyerServiceInf getInstance() {
		return service;
	}
	
	@Override
	public List<BuyerVo> listBuyerNames() {
		 List<BuyerVo> list = null;
		try {
			list=  dao.listBuyerNames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BuyerVo getBuyerDetail(String buyer_id) {
		BuyerVo vo = null;
		try {
			vo = dao.getBuyerDetail(buyer_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
