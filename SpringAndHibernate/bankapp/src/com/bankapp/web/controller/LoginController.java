package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bankapp.model.entity.User;
import com.bankapp.model.service.UserService;


@Controller
public class LoginController {

	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/")
	public String home() {
		return "show";
	}

	@GetMapping("signup")
	public String signupGet(ModelMap map) {
		map.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("signup")
	public String signupPost(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}

	@GetMapping("login")
	public String loginGet(ModelMap map) {
		map.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("login")
	public String loginPost(@ModelAttribute("user") User user, HttpServletRequest req) {

		String username = user.getUsername();
		String password = user.getPassword();
		boolean isValid = userService.verifyDetails(username, password);
		if (isValid) {
			User user1 = userService.getUser(username, password);

			HttpSession session = req.getSession();
			session.setAttribute("user", user1);

			return "redirect:/home";
		} else {
			return "redirect:/login";
		}
	}
}
