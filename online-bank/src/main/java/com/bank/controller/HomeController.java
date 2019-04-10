package com.bank.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.dao.RoleDao;
import com.bank.domain.CheckingAccount;
import com.bank.domain.SavingsAccount;
import com.bank.domain.User;
import com.bank.domain.security.UserRole;
import com.bank.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {

		if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

			if (userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}

			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}

			return "signup";
			
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			System.out.println("HomeController : signupPost : createUser call");
			userService.createUser(user, userRoles);

			return "redirect:/";
		}
	}

	@RequestMapping("/bank")
	public String bank(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		CheckingAccount checkingAccount = user.getCheckingAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();

		model.addAttribute("checkingAccount", checkingAccount);
		model.addAttribute("savingsAccount", savingsAccount);

		return "bank";
	}
}
