/**
 * 
 */
package com.lti.fms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.lti.fms.entities.AdminLogin;
import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.service.AdminService;
import com.lti.fms.service.CustomerLoginService;
import com.lti.fms.service.CustomerRegisterService;

/**
 * @author lntinfotech
 *
 */

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	CustomerRegisterService customerRegisterService;

	@Autowired
	private CustomerLoginService customerLoginService;

	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin() {
		return new ModelAndView("adminlogin");
	}

	/* for getting all admins */
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminlogin(@RequestParam("adminname") String name, @RequestParam("adminpassword") String pass,
			HttpSession httpSession) {
		List<AdminLogin> adminLogins = adminService
				.getallAdmins(); /* calling admin service interface method getallAdmins in a list */
		ModelAndView mv = null;

		/* admin login logic */
		for (AdminLogin adminLogin : adminLogins) {
			if ((adminLogin.getAdminName().equals(name)) && (adminLogin.getAdminPassword().equals(pass))) {
				mv = new ModelAndView("customerlist", "listOfCustomers", customerRegisterService.getallCustomers());
				/*
				 * directing to customerlist jsp,listOfCustomers
				 * key,adminCustomerService.getallCustomers() value
				 */
				break;
			} else {
				mv = new ModelAndView("adminlogin");
			}
		}

		httpSession.setAttribute("hello", "hello");
		return mv;

	}

	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public ModelAndView adminLogout(HttpSession session) {
		session.setAttribute("hello", "");
		session.invalidate();

		return new ModelAndView("adminlogin");

	}

	@RequestMapping("/customerlist/{customerId}")
	public ModelAndView deleteProcess(@PathVariable final Integer customerId) {
		System.out.println("CutomerID is" + customerId);
		customerRegisterService.deleteCustomerRegistration(customerId);
		ModelAndView mv = new ModelAndView("customerlist", "listOfCustomers",
				customerRegisterService.getallCustomers());
		return mv;
	}

	@RequestMapping("/customerEdit/{customerLoginId}")
	public ModelAndView updateCustomerStatus(@PathVariable final int customerLoginId) {
		CustomerLogin customerLogin = customerLoginService.findCustomerLoginById(customerLoginId);
		ModelAndView modelAndView = new ModelAndView("status", "loginData", customerLogin);
		return modelAndView;

	}

	@RequestMapping("/customerEdit/updateCustomerStatusAndEmi/{customerLoginId}")
	public ModelAndView updateCustomerData(@PathVariable final int customerLoginId,
			@RequestParam("status") String status, @RequestParam("emicardno") String emicardno) {

		CustomerLogin customerLogin = customerLoginService.findCustomerLoginById(customerLoginId);
		customerLogin.setCustomerStatus(status);
		customerLogin.setEmiCardNo(emicardno);
		customerLoginService.updateCustomerLogin(customerLogin);
		ModelAndView modelAndView = new ModelAndView("customerlist", "listOfCustomers",
				customerRegisterService.getallCustomers());
		return modelAndView;

	}

	@RequestMapping("/getUserDocuments/{customerId}")
	public ModelAndView showMeCustomerDocuments(@PathVariable("customerId") int customerId) {
		CustomerRegistration customerRegistration = customerRegisterService.findCustomerById(customerId);

		List<String> imglist = new ArrayList<String>();
		imglist.add(customerRegistration.getFileNameAdhar());
		imglist.add(customerRegistration.getFileNameCheque());
		imglist.add(customerRegistration.getFileNamePAN());

		ModelAndView modelAndView = new ModelAndView("customerDocuments", "imglist", imglist);
		return modelAndView;
	}

	

}
