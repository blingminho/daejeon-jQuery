package kr.or.ddit.bh;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DaoTest {
	
	SqlMapClient smc;
	
	{
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public List<BhVo> getBHInfo(){
		List<BhVo> list = null;
		try {
			list=smc.queryForList("lprod.listhbAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
