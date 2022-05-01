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
		System.out.println("Email entered, " + request.getParameter("email"));
		User user = userdao.getUser(email);
		System.out.println("username found, First Name: " + user.getFirstname());

		if (user == null) {
//			// Ask user to login again.
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("title", "User Not Found");
//			map.put("description", "Invalid user...");
			return new ModelAndView("redirect:/login.htm");
		}
		/*Redirect to home screen*/
		return new ModelAndView("redirect:/home.htm");
	}

}
