package com.lti.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.fms.dao.IDetailsDao;
import com.lti.fms.entities.User;

import java.util.List;

/**
 * marking with @Service ,@Service is similar to @Component but used for service implementations
 *  Spring will create object of DetailsServiceImpl class and will keep in bean factory
 */
@Service
@Transactional
public class DetailsServiceImpl implements IDetailsService {


    /**
     * spring will inject with object of DetailsDaoImpl class because @Autowired is mentioned here
     */
    @Autowired
    private IDetailsDao dao;

    public IDetailsDao getDao(){
        return dao;
    }

    public void setDao(IDetailsDao dao){
        this.dao=dao;
    }

    @Override
    public User findUserById(int id) {
       User user= dao.findUserById(id);
       return user;
    }

    @Override
    public User createUser(User user) {
       // transaction opened by spring
         user= dao.createUser(user);
        //transaction closed by spring
        return user;
    }


    @Override
    public User createUser(String name) {
        return dao.createUser(name);
    }
    @Override
    public User updateUser(Integer id,String name) {
        return dao.updateUser(id,name);
    }
    

    @Override
    public List<User> allUsers() {
        List<User>list=dao.allUsers();
        return list;
    }

	@Override
	public void deleteUser(Integer id) {
				dao.deleteUser(id);
	}
}











