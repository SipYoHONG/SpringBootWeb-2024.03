package com.example.sb.exam.service;

import java.util.List;

import com.example.sb.exam.entity.Member;

public interface MemberService {
	
	List<Member> getlistMembers();	
	
	void insertMember(Member member);
}
