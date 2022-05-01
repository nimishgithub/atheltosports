package com.me.athletosports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.athletosports.dao.UserDAO;
import com.me.athletosports.exception.AthletoException;
import com.me.athletosports.pojo.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/success.htm")
	public String successGet() {
		return "success";
	}

 	// Signup User
	@GetMapping("/signup.htm")
	public String signupGet() {
		return "addUserForm";
	}

	@PostMapping("/signup.htm")
	public ModelAndView signupPost(HttpServletRequest request, SessionStatus status, UserDAO userdao) {
		User user = new User();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try {
			userdao.save(user);
		} catch (AthletoException e) {
			System.out.println("User cannot be Added: " + e.getMessage());
		}
		status.setComplete(); //mark it complete
		return new ModelAndView("redirect:/home.htm");
	}

	// Login User
	@GetMapping("/login.htm")
	public String loginUserGet() {
		return "loginUserForm";
	}

	@PostMapping("/login.htm")
	public ModelAndView loginUserPost(HttpServletRequest request, UserDAO userdao) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Email entered, " + request.getParameter("email"));

		User user = userdao.getUser(email);

		System.out.println("User found, First Name: " + user.getFirstname());

//		 || (user.getPassword() != password)

		if (user == null) {
			return new ModelAndView("redirect:/login.htm");
		}

		request.getSession().setAttribute("userInfo", user);

		/*Redirect to home screen*/
		return new ModelAndView("redirect:/home.htm");
	}

	@PostMapping("/logout.htm")
	public ModelAndView logoutUserPost(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", null);
		return new ModelAndView("redirect:/login.htm");
	}

}
