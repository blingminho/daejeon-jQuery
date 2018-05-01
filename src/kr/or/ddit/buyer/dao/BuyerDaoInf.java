package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVo;

public interface BuyerDaoInf {
	public List<BuyerVo> listBuyerNames() throws SQLException;
	public BuyerVo getBuyerDetail(String buyer_id) throws SQLException;
}
