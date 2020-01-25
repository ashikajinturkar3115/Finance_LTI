/**
 * 
 */
package com.lti.fms.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;
import com.lti.fms.service.CustomerLoginService;
import com.lti.fms.service.CustomerRegisterService;
import com.lti.fms.service.EmiPurchaseDescriptionService;

/**
 * @author lntinfotech
 *
 */
@Controller
public class CustomerLoginController {

	int otp = 0;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private CustomerLoginService customerLoginService;

	@Autowired
	private CustomerRegisterService customerRegisterService;

	@Autowired
	private EmiPurchaseDescriptionService emiPurchaseDescriptionService;

	@RequestMapping(value = "/loginCustomer", method = RequestMethod.GET)
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("loginCustomer");
		return mv;
	}

	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {

		ModelAndView mv = null;
		List<EMIPurchaseDescription> descriptions = null;
		List<CustomerLogin> customerLogins = customerLoginService.getAllCustomerLogins();
		Calendar c = Calendar.getInstance();

		if (customerLogins.isEmpty())
			System.out.println("LIST EMPTY");
		for (CustomerLogin customerLogin : customerLogins) {

			if (customerLogin.getCustomerUserName().equals(username)
					&& customerLogin.getCustomerPassword().equals(password)) {

				descriptions = emiPurchaseDescriptionService
						.findAllEmiPurchaseDescriptionByEmiCard(customerLogin.getEmiCardNo());
				if (!descriptions.isEmpty()) {
					for (EMIPurchaseDescription emiPurchaseDescription : descriptions) {
						{
							if (emiPurchaseDescription.getDeductionDate().equals(c.get(Calendar.MONTH) + 1 + "/"
									+ c.get(Calendar.DATE) + "/" + c.get(Calendar.YEAR))) {

								session.setAttribute("emiDes", emiPurchaseDescription);
							}
						}

					}
				}

				System.out.println("inside if ");
				System.out.println("username fetched " + customerLogin.getCustomerUserName());

				mv = new ModelAndView("hellopage", "emiTable", descriptions);
				session.setAttribute("hello", "hello");
				session.setAttribute("customerLogin", customerLogin);
				session.setAttribute("emi", customerLogin.getEmiCard());

				for (EMIPurchaseDescription e : descriptions) {
					System.out.println("emi description1" + e.getDeductionDate());
					System.out.println("emi description2" + e.getMonthlyAmount());
				}

				break;

			} else {

				mv = new ModelAndView("usernotfound");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("hello", "");
		session.invalidate();
		return "logout";
	}

	@RequestMapping("/forgetpassword")
	public ModelAndView forgetpassword() {
		ModelAndView mv = new ModelAndView("forgetpassword");
		return mv;
	}

	@RequestMapping(value = "/getotp", params = "getmail")
	public ModelAndView sendotp(@RequestParam String emailid) {

		try {
			CustomerRegistration customerRegistration = customerRegisterService.findUserEmail(emailid);
			String email = customerRegistration.getEmail();
			System.out.println("email" + emailid);

			Random random = new Random();

			otp = (int) (Math.random() * 9000) + 1000;
			System.out.println("random is " + otp);
			System.out.println("email is" + emailid);

			javaMailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

					messageHelper.setTo(InternetAddress.parse(emailid));

					messageHelper.setSubject("OTP for forget password");
					messageHelper.setText("Your otp is " + otp);

					System.out.println("Sending Done");

				}
			});
			ModelAndView modelAndView = new ModelAndView("forgetpassword", "msg",
					"OTP sent successfully to your email-id");
			return modelAndView;

		} catch (NullPointerException e) {

			System.out.println("caught exception");
			ModelAndView modelAndView = new ModelAndView("forgetpassword", "msgemail",
					"email-id does not match with registered email-id");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/getotp", params = "changeotp")
	public ModelAndView checkOtp(@RequestParam String userotp) {

		ModelAndView modelAndView = null;
		System.out.println("otp got: " + userotp);
		int userotp1 = Integer.parseInt(userotp);
		if (userotp1 == otp) {
			System.out.println("otp compared :");
			modelAndView = new ModelAndView("changePassword");
			return modelAndView;
		} else
			return new ModelAndView("getotp", "message", "OTP doesn't match");

	}

	@RequestMapping(value = "/changepasswordpage")
	public ModelAndView getChangePasswordPage() {
		ModelAndView modelAndView = new ModelAndView("changePassword");
		return modelAndView;
	}

	@RequestMapping(value = "/changepassword")
	public ModelAndView getUserName(@RequestParam("username") String username,
			@RequestParam("newpassword") String newpassword, @RequestParam("confirmpassword") String confirmpassword) {

		ModelAndView mv = null;

		if (newpassword.equals(confirmpassword)) {
			CustomerLogin customerLogin = customerLoginService.findUserByUserName(username);
			System.out.println("unm" + username);

			int CustomerLoginId = customerLogin.getCustomerLoginId();
			System.out.println(customerLogin.getCustomerLoginId());

			customerLogin = customerLoginService.updatePassword(CustomerLoginId, newpassword);
			mv = new ModelAndView("loginCustomer", "message", "Password Changed Successfully");
			return mv;

		} else {
			mv = new ModelAndView("changePassword", "message", "Sorry Retype Password Again");
		}

		return mv;
	}

	@RequestMapping(value = "/payMonthlyEmi/{emiPurchaseDescpritionId}")
	public ModelAndView payEMI(@PathVariable("emiPurchaseDescpritionId") int id) {

		return new ModelAndView("payMonthlyEmi", "emides",
				emiPurchaseDescriptionService.findEmiPurchaseDescriptionById(id));
	}

	@RequestMapping(value = "/payEmi/{emiPurchaseDescpritionId}")
	public ModelAndView payMonthlyEmiNow(@PathVariable("emiPurchaseDescpritionId") int emiPurchaseDescpritionId,
			HttpSession httpSession) {
		/**
		 * Creating Objects
		 */
		System.out.println("yessss got it");
		EMIPurchaseDescription emiPurchaseDescription = emiPurchaseDescriptionService
				.findEmiPurchaseDescriptionById(emiPurchaseDescpritionId);
		emiPurchaseDescription.setStatus("PAID");
		EMICard emiCard = emiPurchaseDescriptionService
				.findEmiCardByEmiCardId(emiPurchaseDescription.getEmiCardNumber());
		CustomerLogin customerLogin = (CustomerLogin) httpSession.getAttribute("customerLogin");

		/**
		 * Checking null
		 */

		if (emiCard == null) {
			System.out.println("Yes  emi card is Null");
		}

		if (customerLogin == null) {
			System.out.println("Yes customer Login is Null");
		}

		/**
		 * update available balance
		 */

		emiCard.setAvailableBalance(emiCard.getAvailableBalance() - (double) emiPurchaseDescription.getMonthlyAmount());

		customerLogin.setEmiCard(emiCard);
		customerLoginService.updateCustomerLogin(customerLogin);

		emiPurchaseDescriptionService.updateEmiPurchaseDescription(emiPurchaseDescription);
		return new ModelAndView("hellopage");
	}
}
