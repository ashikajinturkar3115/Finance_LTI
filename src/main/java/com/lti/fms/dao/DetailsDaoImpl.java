package com.lti.fms.dao;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * marking with @Repository is similar to @Component but used for Dao implementation classes,
 * spring will keep instance of DetailsDaoImpl and the object will be kept in bean factory
 *
 */
@Repository
public class DetailsDaoImpl implements IDetailsDao {

    @PersistenceContext
    private EntityManager em;

    public DetailsDaoImpl(){
    }

    @Override
    public User findUserById(int id) {
      User u= em.find(User.class,id);
      return u;
    }

    @Override
    public User createUser(User user){
        user=em.merge(user);
        return user;
    }

    @Override
    public User createUser(String name) {
        User user=new User();
        user.setName(name);
        user=em.merge(user);
        return user;
    }
    @Override
    public User updateUser(Integer id,String name) {
       User user=em.find(User.class,id);
       user.setName(name);
        user=em.merge(user);
        return user;
    }

    @Override
    public List<User>allUsers(){
       Query q= em.createQuery("from User");
       List<User>list=q.getResultList();
       return list;
    }

	@Override
	public void deleteUser(Integer id) {
		User user=findUserById(id);
		em.remove(user);

	}
}
