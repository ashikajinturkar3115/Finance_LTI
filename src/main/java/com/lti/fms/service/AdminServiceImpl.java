package com.lti.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.fms.dao.AdminDao;
import com.lti.fms.entities.AdminLogin;

import java.util.List;

/**
 * marking with @Service ,@Service is similar to @Component but used for service implementations
 *  Spring will create object of AdminServiceImpl class and will keep in bean factory
 */
@Service
@Transactional 
public class AdminServiceImpl implements AdminService {
	
	   /**
     * spring will inject with object of AdminDaoImpl class because @Autowired is mentioned here
     */
	 @Autowired
	    private AdminDao dao;

	    public AdminDao getDao(){
	        return dao;
	    }
	    

	    @Override
	    public List<AdminLogin> getallAdmins() {
	        List<AdminLogin>list=dao.getallAdmins();
	        return list;
	    }

}
