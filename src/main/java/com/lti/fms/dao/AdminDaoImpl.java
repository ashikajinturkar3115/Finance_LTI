package com.lti.fms.dao;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.AdminLogin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * marking with @Repository is similar to @Component but used for Dao implementation classes,
 * spring will keep instance of AdminDaoImpl and the object will be kept in bean factory
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao{

	@PersistenceContext              
    private EntityManager em;

    @Override
    public List<AdminLogin> getallAdmins(){
       Query q= em.createQuery("from AdminLogin");
       List <AdminLogin> list=q.getResultList();
       return list;
    }
	
}


	
	


