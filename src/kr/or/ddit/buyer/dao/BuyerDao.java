package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVo;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.dao.LprodDao;

public class BuyerDao implements BuyerDaoInf {

	SqlMapClient smc;
	private static BuyerDaoInf doa = new BuyerDao();
	
	public static BuyerDaoInf getInstanceDao(){
		if (doa == null)
			doa = new BuyerDao();
		return doa;
	}
	
	
	{
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<BuyerVo> listBuyerNames() throws SQLException {
		List<BuyerVo> list = null;
		list= smc.queryForList("buyer.listBuyerNames");
		return list;
	}
	
	
	
	@Override
	public BuyerVo getBuyerDetail(String buyer_id) throws SQLException {
		String data = buyer_id;
		BuyerVo buyVo=null;
		buyVo= (BuyerVo)smc.queryForObject("buyer.getBuyerDetail",data);
		return buyVo;
	}
	
	
	//test
//	public static void main(String[] args) {
//		String data = "참존";
//		BuyerDaoInf dao = BuyerDao.getInstanceDao();
//		try {
//			BuyerVo vo = dao.getBuyerDetail(data);
//			System.out.println(vo.getBuyer_id());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		/////////////
//		try {
//			List<BuyerVo> list = dao.listBuyerNames();
//			System.out.println("listBuyerNames  : "+ list.get(0).getBuyer_id());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}

}
