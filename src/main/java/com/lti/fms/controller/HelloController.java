package com.lti.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.fms.entities.User;
import com.lti.fms.service.IDetailsService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private IDetailsService service;
    public IDetailsService getService() {
        return service;
    }
    public void setService(IDetailsService service) {
        this.service = service;
    }
    private int i = 0;
    @RequestMapping("/")
    public ModelAndView index() {
       return new ModelAndView("index",new HashMap<>());
    }
        @RequestMapping("/hello")
    public ModelAndView sayHello() {
        i++;
        ModelAndView mv = new ModelAndView("hellopage",
                "message", "Hello request count=" + i);
        return mv;
    }
    @RequestMapping(value = "/userdetails",method = RequestMethod.GET)
    public ModelAndView userDetails(@RequestParam("id")int id) {
        User user = service.findUserById(id);
        if (user == null) {
          ModelAndView mv=new ModelAndView("usernotfound","id",id);
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
    public ModelAndView createUserForm(){
        ModelAndView mv=new ModelAndView("createuser");
        return mv;
    }
    @RequestMapping("/deleteuser")
    public ModelAndView deleteUserForm(){
        ModelAndView mv=new ModelAndView("delete");
        return mv;
    }
    @RequestMapping("/update")
    public ModelAndView updateUserForm(){
        ModelAndView mv=new ModelAndView("updateuser");
        return mv;
    }
    @RequestMapping("/createprocess")
    public ModelAndView createProcess(@RequestParam String name){
        User user=service.createUser(name);
        Map<String,Object>map=new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        ModelAndView mv=new ModelAndView("usercreated",map);
        return mv;
    }
    @RequestMapping("/updateprocess")
    public ModelAndView createProcess(@RequestParam Integer id,@RequestParam String name){
        User user=service.updateUser(id,name);
        Map<String,Object>map=new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        ModelAndView mv=new ModelAndView("userupdated",map);
        return mv;
    }
    @RequestMapping("/deleteprocess")
    public ModelAndView deleteProcess(@RequestParam Integer id){
     service.deleteUser(id);
        ModelAndView mv=new ModelAndView("deleted");
        return mv;
    }
    
    @RequestMapping("/registerCustomer")
    public ModelAndView registerCustomer()
    {
    	ModelAndView mv=new ModelAndView("registerCustomer");
        return mv;
    }

    
    
}



























