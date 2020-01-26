/**
 * 
 */
package com.lti.fms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lti.fms.service.CustomerLoginService;
import com.lti.fms.service.EmiPurchaseDescriptionService;
import com.lti.fms.service.ProductService;

import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;
import com.lti.fms.entities.ProductDescription;
import com.lti.fms.entities.ProductPurchased;
import com.lti.fms.entities.Products;

/**
 * @author lntinfotech/Ashika
 *
 */

@Controller
public class DashboardController {

	private double val = 0;

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerLoginService customerLoginService;

	@Autowired
	private EmiPurchaseDescriptionService emiPurchaseDescriptionService;

	@RequestMapping("/productlist")
	public ModelAndView getProductList(HttpSession httpSession) {

		CustomerLogin customerLogin = (CustomerLogin) httpSession.getAttribute("customerLogin");

		/*
		 * ModelAndView modelAndView = new
		 * ModelAndView("productList","emicard",customerLogin.getEmiCard());
		 */

		List<Products> products = productService.getAllProducts();

		ModelAndView modelAndView = new ModelAndView("productList", "products", products);

		return modelAndView;
	}

	@RequestMapping("/buyProduct/{productId}")
	public ModelAndView buyProductAndShowDescription(@PathVariable("productId") int productId,
			HttpSession httpSession) {
		ModelAndView modelAndView = null;
		List<EMIPurchaseDescription> eList = new ArrayList<EMIPurchaseDescription>();

		double totalAmountTobePaid = 0;

		CustomerLogin customerLogin = (CustomerLogin) httpSession.getAttribute("customerLogin");
		EMICard emiCard = customerLogin.getEmiCard();

		double totalRemainingAmountToBeSpent = 0;

		List<EMIPurchaseDescription> descriptions = emiPurchaseDescriptionService
				.findAllEmiPurchaseDescriptionByEmiCard(customerLogin.getEmiCardNo());
		if (descriptions.isEmpty()) {
			totalRemainingAmountToBeSpent = emiCard.getAvailableBalance();
		} else {
			totalRemainingAmountToBeSpent = 0;
		}

		if (!descriptions.isEmpty()) {
			for (EMIPurchaseDescription emiPurchaseDescription : descriptions) {
				if (emiPurchaseDescription.getStatus().equals("PENDING")) {
					eList.add(emiPurchaseDescription);
				}
			}

			for (EMIPurchaseDescription emiPurchaseDescription : eList) {
				totalAmountTobePaid = totalAmountTobePaid + emiPurchaseDescription.getMonthlyAmount();
			}
			totalRemainingAmountToBeSpent = emiCard.getAvailableBalance() - totalAmountTobePaid;
		}
		System.out.println("product id" + productId);

		Products products = productService.findProductById(productId);

		ProductDescription productDescription = products.getProductDescription();
		modelAndView = new ModelAndView("productDescription", "description", productDescription);

		if (totalRemainingAmountToBeSpent >= products.getProductPrice()) {
			modelAndView.addObject("disable", "no");
		} else {
			modelAndView.addObject("disable", "yes");
		}

		return modelAndView;

	}

	@RequestMapping("/payNow/{productId}")
	public String payNow(@PathVariable("productId") int productId, @RequestParam("choice") String choice,
			HttpSession httpSession, RedirectAttributes redirectAttributes) {
		System.out.println("choice====" + choice);
		ModelAndView modelAndView = null;
		int choice2 = Integer.parseInt(choice);
		/**
		 * Generating current date
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String date = sdf.format(new Date());

		Calendar c = Calendar.getInstance();
		/*
		 * String dateCurrent = c.get(Calendar.MONTH) + 1 + "-" + c.get(Calendar.DATE) +
		 * "-" + c.get(Calendar.YEAR);
		 * 
		 * Set<String> set = new HashSet<String>(); set.add(dateCurrent); for (int i =
		 * 1; i < choice2; i++) { c.add(Calendar.MONTH, 1);
		 * 
		 * set.add((c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE) + "-" +
		 * c.get(Calendar.YEAR)); }
		 * 
		 * for (String string : set) { System.out.println("Date got is : ====" +
		 * string); }
		 */

		/*
		 * Get data from objects
		 */
		CustomerLogin customerLogin = (CustomerLogin) httpSession.getAttribute("customerLogin");
		if (customerLogin == null) {
			System.out.println("customer login is null");
		} else {
			System.out.println(customerLogin.getCustomerPassword() + "cust pass");
		}
		EMICard emiCard = customerLogin.getEmiCard();

		if (emiCard == null) {
			System.out.println("emi card is null");
		} else {
			System.out.println(emiCard.getAvailableBalance() + "emicard available bal");
			System.out.println(emiCard.getCardType() + "emi card card type");
		}

		Products products = productService.findProductById(productId);

		/**
		 * Setting Data in product purchased
		 */

		ProductPurchased productPurchased = new ProductPurchased();
		productPurchased.setProductId(products.getProductID());
		productPurchased.setPurchaseDate(date);
		productPurchased.setItemPurchasedPrice(products.getProductPrice());

		productPurchased.setEmiCardNo(emiCard.getEmiCardNo());
		productPurchased.setEmiType(emiCard.getCardType());
		productPurchased.setUserId(customerLogin.getCustomerLoginId());

		List<ProductPurchased> productPurchaseds = new ArrayList<ProductPurchased>();
		productPurchaseds.add(productPurchased);

		/**
		 * 
		 */
		emiCard.setAvailableBalance(emiCard.getAvailableBalance() - (double) (products.getProductPrice() / choice2));
		/**
		 * 
		 */
		emiCard.setProductPurchased(productPurchaseds);

		for (int i = 1; i <= choice2; i++) {
			EMIPurchaseDescription emiPurchaseDescription = new EMIPurchaseDescription();
			emiPurchaseDescription.setEmiCardNumber(customerLogin.getEmiCardNo());
			emiPurchaseDescription.setMonthlyAmount((products.getProductPrice()) / (Integer.parseInt(choice)));
			emiPurchaseDescription.setStatus("PENDING");
			if (i == 1) {
				emiPurchaseDescription.setDeductionDate(
						c.get(Calendar.MONTH) + 1 + "/" + c.get(Calendar.DATE) + "/" + c.get(Calendar.YEAR));
				emiPurchaseDescription.setStatus("PAID");
				emiPurchaseDescription
						.setTotalAmount(products.getProductPrice() - emiPurchaseDescription.getMonthlyAmount());
				val = products.getProductPrice() - emiPurchaseDescription.getMonthlyAmount();
			} else {
				c.add(Calendar.MONTH, 1);
				emiPurchaseDescription.setDeductionDate(
						(c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DATE) + "/" + c.get(Calendar.YEAR));
				emiPurchaseDescription.setStatus("PENDING");

				emiPurchaseDescription.setTotalAmount((int) (val - emiPurchaseDescription.getMonthlyAmount()));
				val = (val - emiPurchaseDescription.getMonthlyAmount());
			}

			emiPurchaseDescriptionService.createEmiPurchaseDescription(emiPurchaseDescription);
		}

		productPurchased.setEmiCard(emiCard);
		customerLogin.setEmiCard(emiCard);

		CustomerLogin customerLogin2 = customerLoginService.updateCustomerLogin(customerLogin);
		System.out.println("Customer Login is Successfully Saved");

		modelAndView = new ModelAndView("hellopage", "customerLogin", customerLogin2);
		redirectAttributes.addAttribute("username", customerLogin.getCustomerUserName());
		redirectAttributes.addAttribute("password", customerLogin.getCustomerPassword());
		return "redirect:/productlist";

	}

	/*
	 * @RequestMapping("/payEmi/{emicardNumber}") public ModelAndView
	 * payMonthlyEmi(@PathVariable("emicardNumber") String emicardNumber) { EMICard
	 * emiCard =
	 * emiPurchaseDescriptionService.findEmiCardByEmiCardId(emicardNumber);
	 * 
	 * 
	 * if(emiCard != null) { System.out.println(emiCard.getAvailableBalance() +
	 * emiCard.getTotalBalance()); }
	 * 
	 * 
	 * return null; }
	 */

}
