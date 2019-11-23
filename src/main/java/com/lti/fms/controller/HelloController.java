package com.lti.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.User;
import com.lti.fms.service.CustomerLoginService;
import com.lti.fms.service.CustomerRegisterService;
import com.lti.fms.service.IDetailsService;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;

@Controller
public class HelloController {
	@Autowired
	private IDetailsService service;

	@Autowired
	private CustomerLoginService customerLoginService;

	@Autowired
	private CustomerRegisterService customerRegisterService;

	public IDetailsService getService() {
		return service;
	}

	public void setService(IDetailsService service) {
		this.service = service;
	}

	public CustomerRegisterService getCustomerRegisterService() {
		return customerRegisterService;
	}

	public void setCustomerRegisterService(CustomerRegisterService customerRegisterService) {
		this.customerRegisterService = customerRegisterService;
	}

	private int i = 0;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", new HashMap<>());
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		i++;
		ModelAndView mv = new ModelAndView("hellopage", "message", "Hello request count=" + i);
		return mv;
	}

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public ModelAndView userDetails(@RequestParam("id") int id) {
		User user = service.findUserById(id);
		if (user == null) {
			ModelAndView mv = new ModelAndView("usernotfound", "id", id);
			return mv;
		}
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("id", id);
		modelMap.put("name", user.getName());
		ModelAndView mv = new ModelAndView("userdetails", modelMap);
		return mv;
	}

	@RequestMapping("/getdetails")
	public ModelAndView detailsForm() {
		return new ModelAndView("detailsform", new HashMap<>());
	}

	@RequestMapping("/createuser")
	public ModelAndView createUserForm() {
		ModelAndView mv = new ModelAndView("createuser");
		return mv;
	}

	@RequestMapping("/deleteuser")
	public ModelAndView deleteUserForm() {
		ModelAndView mv = new ModelAndView("delete");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView updateUserForm() {
		ModelAndView mv = new ModelAndView("updateuser");
		return mv;
	}

	@RequestMapping("/createprocess")
	public ModelAndView createProcess(@RequestParam String name) {
		User user = service.createUser(name);
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		ModelAndView mv = new ModelAndView("usercreated", map);
		return mv;
	}

	@RequestMapping("/updateprocess")
	public ModelAndView createProcess(@RequestParam Integer id, @RequestParam String name) {
		User user = service.updateUser(id, name);
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		ModelAndView mv = new ModelAndView("userupdated", map);
		return mv;
	}

	@RequestMapping("/deleteprocess")
	public ModelAndView deleteProcess(@RequestParam Integer id) {
		service.deleteUser(id);
		ModelAndView mv = new ModelAndView("deleted");
		return mv;
	}

	@RequestMapping("/registerPage")
	public ModelAndView registerCustomerPage() {
		ModelAndView mv = new ModelAndView("registerCustomer");
		return mv;
	}

	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomer(
			@ModelAttribute("customerRegistration") CustomerRegistration customerRegistration) {

		CustomerRegistration cuRegistration = null;

		CustomerLogin customerLogin = new CustomerLogin();

		customerLogin.setCustomerUserName(customerRegistration.getUsername());
		customerLogin.setCustomerPassword(customerRegistration.getPassword());
		customerLogin.setCustomerStatus("DEACTIVATED");
		CustomerLogin customerLogin2 = customerLoginService.createCustomerLogin(customerLogin);

		System.out.println(customerLogin2.getCustomerLoginId() + "++++++++++++++++++++++++++"
				+ customerLogin2.getCustomerPassword());

		customerRegistration.setCustomerLoginId(customerLogin2.getCustomerLoginId());
		cuRegistration = customerRegisterService.createCustomer(customerRegistration);
		if (customerRegistration != null) {
			System.out.println(customerRegistration.getAccountNo() + customerRegistration.getAddress()
					+ customerRegistration.getCustomerId());
		}

		System.out.println("leaving register page");
		System.out.println(cuRegistration.getCustomerId() + "id=========" + cuRegistration.getAddress());
		ModelAndView mv = new ModelAndView("uploadFile", "userId", cuRegistration.getCustomerId());
		return mv;
	}

	@RequestMapping("/uploadFile")
	public ModelAndView uploadFiles(@RequestParam("file") MultipartFile adhar,
			@RequestParam("file2") MultipartFile cheque, @RequestParam("file3") MultipartFile pan,
			@RequestParam("customerId") int customerId, HttpServletRequest httpServletRequest) throws IOException {

		CustomerRegistration customerRegistration = customerRegisterService.findCustomerById(customerId);

		String uploadFolder = httpServletRequest.getServletContext().getRealPath("/uploadfolder");
		File dFile = new File(uploadFolder);
		if (!dFile.exists()) {
			dFile.mkdir();
		}

		System.out.println(customerRegistration.getAddress());
		System.out.println(adhar.getContentType());
		System.out.println(adhar.getOriginalFilename());
		System.out.println(uploadFolder + "/" + adhar.getOriginalFilename());

		try {
			if (!adhar.isEmpty()) {
				customerRegistration.setContentTypeAdhar(adhar.getContentType());
				customerRegistration.setFileNameAdhar(adhar.getOriginalFilename());
				customerRegistration.setFilePathAdhar(uploadFolder + "/" + adhar.getOriginalFilename());
			}

			if (!cheque.isEmpty()) {
				customerRegistration.setContentTypeCheque(cheque.getContentType());
				customerRegistration.setFileNameCheque(cheque.getOriginalFilename());
				customerRegistration.setFilePathCheque(uploadFolder + "/" + cheque.getOriginalFilename());
			}

			if (!pan.isEmpty()) {
				customerRegistration.setContentTypePAN(pan.getContentType());
				customerRegistration.setFileNamePAN(pan.getOriginalFilename());
				customerRegistration.setFilePathPAN(uploadFolder + "/" + pan.getOriginalFilename());
			}

		} catch (Exception e) {

		}

		BufferedImage src1 = ImageIO.read(new ByteArrayInputStream(adhar.getBytes()));
		ImageIO.write(src1, "jpg", new File(uploadFolder + "/" + adhar.getOriginalFilename()));

		BufferedImage src2 = ImageIO.read(new ByteArrayInputStream(cheque.getBytes()));
		ImageIO.write(src2, "jpg", new File(uploadFolder + "/" + cheque.getOriginalFilename()));

		BufferedImage src3 = ImageIO.read(new ByteArrayInputStream(pan.getBytes()));
		ImageIO.write(src3, "jpg", new File(uploadFolder + "/" + pan.getOriginalFilename()));

		ArrayList<String> imgNames = new ArrayList<String>();
		imgNames.add(customerRegistration.getFileNameAdhar());
		imgNames.add(customerRegistration.getFileNameCheque());
		imgNames.add(customerRegistration.getFileNamePAN());
		customerRegisterService.updateCustomer(customerRegistration);
		System.out.println("loc : " + uploadFolder);

		ModelAndView mv = new ModelAndView("success", "fileName", imgNames);

		return mv;

	}

	@RequestMapping("/getimage/{imagePath}")

	@ResponseBody
	public byte[] getImage(@PathVariable("imagePath") String imagePath, HttpServletRequest request) throws IOException {
		System.out.println("In Image controller************");
		String rpath = request.getServletContext().getRealPath("/uploadfolder") + "/" + imagePath + ".jpg";
		System.out.println(rpath + "path/*******************");
		Path path = Paths.get(rpath);
		System.out.println("In Image controller************" + path);

		byte[] data = Files.readAllBytes(path);
		System.out.println("data***********" + Arrays.toString(data));
		return data;
	}

}
