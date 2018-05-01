package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVo;

public interface BuyerServiceInf {
	public List<BuyerVo> listBuyerNames();
	public BuyerVo getBuyerDetail(String buyer_id) ;
}
