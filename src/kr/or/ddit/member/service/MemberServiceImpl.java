package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.ziptb.vo.ZipVo;

public class MemberServiceImpl implements MemberServiceInf{

	private static MemberServiceInf service;
	
	public static MemberServiceInf getInstance(){
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	private MemberDaoInf dao;
	{
		dao = MemberDaoImpl.getInstance();
	}
	
	
	@Override
	public List<MemberVo> getMemberAll() {
		return dao.getMemberAll();
	}


	@Override
	public String idCheck(String mem_id) {
		String id = null;
		try {
			id = dao.idCheck(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


	@Override
	public List<ZipVo> zipSearch(String dong) {
		List<ZipVo> list = null;
		try {
			list = dao.zipSearch(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public String insertMember(MemberVo vo) {
		String id = null;
		try {
			id = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
