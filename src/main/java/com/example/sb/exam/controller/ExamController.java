package com.example.sb.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sb.exam.entity.Member;

@Controller
public class ExamController {

    @GetMapping("/exam/member")
	public String getMemberList(Model model) {
		List<Member> members = new ArrayList<>();
	  	members.add(new Member(1, "james", 22, "USA")); // 리스트에 멤버 추가
        members.add(new Member(2, "jung", 19, "Korea"));
        members.add(new Member(3, "risa", 25, "China"));
        members.add(new Member(4, "sara", 30, "Japan"));
        members.add(new Member(5, "brian", 28, "UK"));
        
        model.addAttribute("members", members);
        return "member/list";
    }
}