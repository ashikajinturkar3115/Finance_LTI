/**
 * 
 */
package com.lti.fms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;
import com.lti.fms.entities.ProductPurchased;
import com.lti.fms.entities.Products;
import com.lti.fms.service.CustomerLoginService;
import com.lti.fms.service.CustomerRegisterService;
import com.lti.fms.service.EmiPurchaseDescriptionService;
import com.lti.fms.service.ProductService;

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

	@Autowired
	private ProductService productService;

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
		List<Products> list = new ArrayList<Products>();

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
				/**
				 * 
				 */
				if (!emiPurchaseDescriptionService.findProductIdByEMICardNo(customerLogin.getEmiCardNo()).isEmpty()) {
					List<ProductPurchased> productPurchasedList = emiPurchaseDescriptionService
							.findProductIdByEMICardNo(customerLogin.getEmiCardNo());

					for (ProductPurchased productPurchased : productPurchasedList) {

						productPurchased.getProductId();
						list.add(productService.findProductById(productPurchased.getProductId()));
						System.out.println("PRODUCT NOS " + productPurchased.getProductId());
						System.out.println("PRODUCT NAME "
								+ productService.findProductById(productPurchased.getProductId()).getProductName());

					}
					for (Products products : list) {
						System.out.println("PRODUCT ID " + products.getProductID());
						System.out.println("PRODUCT NAME " + products.getProductName());
					}
					session.setAttribute("list", list);
				}
				/**
				 * 
				 */
				System.out.println("inside if ");
				System.out.println("username fetched " + customerLogin.getCustomerUserName());

				mv = new ModelAndView("hellopage", "emiTable", descriptions);
				session.setAttribute("hello", "hello");
				session.setAttribute("customerLogin", customerLogin);
				session.setAttribute("emi", customerLogin.getEmiCard());
				session.setAttribute("custName", customerRegisterService.findUserByUserName(username).getName());
				session.setAttribute("cardType", customerRegisterService.findUserByUserName(username).getCardType());
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

		CustomerLogin customerLogin = null;

		List<CustomerLogin> customerLogins = customerLoginService.getAllCustomerLogins();
		Calendar c = Calendar.getInstance();
		if (customerLogins.isEmpty())
			System.out.println("LIST EMPTY");
		for (CustomerLogin customerLogin1 : customerLogins) {
			if (customerLogin1.getCustomerUserName().equals(username.trim())) {

				System.out.println("inside if ");
				System.out.println("username fetched " + customerLogin1.getCustomerUserName());

				if (newpassword.trim().equals(confirmpassword.trim()))

				{
					customerLogin1 = customerLoginService.findUserByUserName(username);
					System.out.println("unm" + username);

					int CustomerLoginId = customerLogin1.getCustomerLoginId();
					System.out.println(customerLogin1.getCustomerLoginId());

					customerLogin1 = customerLoginService.updatePassword(CustomerLoginId, newpassword);
					mv = new ModelAndView("loginCustomer", "message", "Password Changed Successfully");
					return mv;

				} else {
					mv = new ModelAndView("changePassword", "message", "Sorry Retype Password Again");
				}

				return mv;
			}

			else {

				mv = new ModelAndView("changePassword", "msgnouser",
						"Sorry..!!userame does not match with registered username..!!");

			}

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

	// Handling single file upload request
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

		// Save file on system
		if (!file.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File("D:/SingleFileUpload", file.getOriginalFilename())));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();

			model.addAttribute("msg", "File uploaded successfully.");
		} else {
			model.addAttribute("msg", "Please select a valid file..");
		}

		return "fileUploadForm";
	}

}
