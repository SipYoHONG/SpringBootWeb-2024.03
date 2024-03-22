package com.example.sb.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sb.exam.entity.Member;
import com.example.sb.exam.service.MemberService;

@Controller
@RequestMapping("/exam")
public class MemberController {

	@Autowired
	private MemberService memSvc;

	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("/insert")
	public String insertMember(String name, int age, String country) {
		memSvc.insertMember(new Member(name, age, country));
		return "redirect:/exam/list";
	}

	@GetMapping("/list")
	public String List(Model model) {
		model.addAttribute("memList", memSvc.getlistMembers());
		return "list";
	}
}
