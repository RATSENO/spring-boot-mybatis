package com.bd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bd.model.req.UserLoginDTO;
import com.bd.model.res.UserDTO;
import com.bd.service.LoginService;
import com.bd.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(name = "loginForm") UserLoginDTO userLoginDTO, Model model, HttpSession session) {
		UserDTO userDTO = loginService.userLogin(userLoginDTO);
		if(userDTO != null) {
			
			session.setAttribute("SID", userDTO.getId());
			session.setAttribute("SNAME", userDTO.getName());
			session.setAttribute("SSEX", userDTO.getSex());
			
			model.addAttribute("userInfo", userDTO);
			return "boardList";
			
		}else {
			
			model.addAttribute("invalidCredentials", true);
			return "login";
		}
	}
	
}
