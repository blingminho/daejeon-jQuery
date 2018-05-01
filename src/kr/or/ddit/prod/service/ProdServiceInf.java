package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVo;

public interface ProdServiceInf {
	public List<ProdVo> listProdNames(String lprod_gu) throws SQLException;
	public ProdVo detailProd(String prod_id) throws SQLException;
}
