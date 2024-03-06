package com.example.sb.users;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userSvc;
	
	@GetMapping("/list/{page}")
	public String list(@PathVariable int page, Model model) {
		List<User> list = userSvc.getUserList(page);
		model.addAttribute("userList", list);
		return "user/list";
	}
	
}
