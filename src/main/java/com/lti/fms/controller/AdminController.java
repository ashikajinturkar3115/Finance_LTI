/**
 * 
 */
package com.lti.fms.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import com.lti.fms.entities.AdminLogin;
import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.EMICard;
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
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
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
		modelAndView.addObject("emicardno", customerLogin.getEmiCardNo());
		return modelAndView;

	}

	@RequestMapping("/customerEdit/updateCustomerStatusAndEmi/{customerLoginId}")
	public ModelAndView updateCustomerData(@PathVariable final int customerLoginId,
			@RequestParam("status") String status, @RequestParam("emicardno") String emicardno) {

		ModelAndView modelAndView = null;
		CustomerLogin customerLogin = customerLoginService.findCustomerLoginById(customerLoginId);

		if (customerLogin.getEmiCardNo() != null) {
			System.out.println("inside if emi number if exists: ===" + customerLogin.getEmiCardNo());
			customerLogin.setCustomerStatus(status);
			modelAndView = new ModelAndView("adminlogin", "emicardno", customerLogin.getEmiCardNo());
		} else {
			EMICard emiCard = new EMICard();
			System.out.println("inside else");
			customerLogin.setEmiCardNo(emicardno);
			customerLogin.setCustomerStatus(status);
			System.out.println("sTATUS" + customerLogin.getCustomerStatus());
			emiCard.setEmiCardNo(emicardno);
			// System.out.println(customerLoginService.findUserByUserName("abc").getCustomerStatus());
			System.out.println("Card Type of user from Register table is "
					+ customerRegisterService.findUserByUserName(customerLogin.getCustomerUserName()).getCardType());
			// System.out.println("card
			// type===="+customerRegisterService.findCustomerByLoginId(customerLoginId).getCardType());
			// PROBLEM
			emiCard.setCardType(
					customerRegisterService.findUserByUserName(customerLogin.getCustomerUserName()).getCardType());

			// customerRegisterService.findUserByUserName(customerLogin.getCustomerUserName()).getCardType();

			if (customerRegisterService.findUserByUserName(customerLogin.getCustomerUserName()).getCardType()
					.equals("GOLD")) {
				System.out.println("GOLD TYPE");
				emiCard.setTotalBalance(10000);
				emiCard.setAvailableBalance(10000);

			} else {
				System.out.println("TITANIUM TYPE");
				emiCard.setTotalBalance(20000);
				emiCard.setAvailableBalance(20000);
			}
			System.out.println("inside else setting emi card");
			customerLogin.setEmiCard(emiCard);
		}
		System.out.println("PERSIST");
		customerLoginService.updateCustomerLogin(customerLogin);

		modelAndView = new ModelAndView("customerlist", "listOfCustomers", customerRegisterService.getallCustomers());
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
