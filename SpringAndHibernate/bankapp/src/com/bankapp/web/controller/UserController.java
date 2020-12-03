package com.bankapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entity.User;
import com.bankapp.model.entity.UserType;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.UserBean;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("showallusers")
	public ModelAndView showallusers(ModelAndView mv) {
		mv.setViewName("showallusers");
		mv.addObject("users", userService.getAllUser());
		return mv;
	}

	// del the book
	@GetMapping("deleteuser")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(id);
		return "redirect:/showallusers";
	}

	// update the book: get and post

	// add an new book
	@GetMapping("updateuser")
	public String addUserGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.getUserById(id);
		map.addAttribute("user", user);
		return "updateuser";
	}


	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adduser";
		} else {
			if (userBean.getUid() == 0) {
				userService.addUser(userBean);
			} else {
				userService.updateUser(userBean.getUid(), userBean);
			}
			return "redirect:/showallusers";
		}
			
	}
	
	@ModelAttribute(value = "usertypes")
	public UserType[] userType() {
		return UserType.values();
	}

}