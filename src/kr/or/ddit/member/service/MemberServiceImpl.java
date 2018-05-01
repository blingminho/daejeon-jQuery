package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.vo.MemberVo;

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

}
