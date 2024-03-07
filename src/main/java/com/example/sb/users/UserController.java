package com.example.sb.users;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userSvc;

	@GetMapping("/list/{page}")
	public String list(@PathVariable int page, Model model) {
		List<User> list = userSvc.getUserList(page);
		model.addAttribute("userList", list);
		return "user/list";
	}

	@GetMapping("/register")
	public String register() {
		return "user/register";
	}

	@PostMapping("/register")
	public String registerProc(String uid, String pwd, String pwd2, String uname, String email) {
		if (userSvc.getUserByUid(uid) == null && pwd.equals(pwd2)) {
			String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
			User user = new User(uid, hashedPwd, uname, email);
			userSvc.registerUser(user);
		}
		return "redirect:/user/list/1";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String loginProc(String uid, String pwd, Model model) {
		int result = userSvc.login(uid,pwd);
		if(result == userSvc.CORRECT_LOGIN) {
			model.addAttribute("msg", userSvc.getUserByUid(uid).getUname() + "님 환영합니다.");
		} else {
			model.addAttribute("msg", "아이디가 존재하지 않습니다.");
		}
		return "user/loginResult";
	}
	
	 @GetMapping("/update/{uid}")
    public String update(@PathVariable String uid, Model model) {
        User user = userSvc.getUserByUid(uid);
        model.addAttribute("user", user);
        return "user/update";
    }
    @PostMapping("/update")
    public String updateProc(String uid, String pwd, String pwd2, String uname, String email) {
    	User user = userSvc.getUserByUid(uid);
        if(pwd != null && pwd.equals(pwd2)) {
            String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
            user.setPwd(hashedPwd);
        } 
        user.setUname(uname);
        user.setEmail(email);
        userSvc.updateUser(user);
        return "redirect:/user/list/1";
    }

    @GetMapping("/delete/{uid}")
    public String delete(@PathVariable String uid){
        userSvc.deleteUser(uid);
        return "redirect:/user/list/1";
    }
}