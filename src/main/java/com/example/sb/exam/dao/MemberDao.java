package com.example.sb.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.sb.exam.entity.Member;

@Mapper
public interface MemberDao {
	
	@Select("SELECT * FROM member")
	List<Member> getlistMembers();
	
	@Insert("INSERT INTO member VALUES(default, #{name}, #{age}, #{country})")
	void insertMember(Member member);
}
