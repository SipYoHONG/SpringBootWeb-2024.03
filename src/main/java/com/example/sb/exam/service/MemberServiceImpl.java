package com.example.sb.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb.exam.dao.MemberDao;
import com.example.sb.exam.entity.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired private MemberDao mDao;
	
	@Override
	public List<Member> getlistMembers() {
		return mDao.getlistMembers();
	}
	
	@Override
	public void insertMember(Member member) {
		mDao.insertMember(member);
		
	}
}
