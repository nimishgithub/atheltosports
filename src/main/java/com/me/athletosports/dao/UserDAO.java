package com.me.athletosports.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.me.athletosports.exception.AthletoException;
import com.me.athletosports.pojo.User;

@Component
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public void save(User user) throws AthletoException {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AthletoException("Could not delete user " + user.getEmail(), e);
        }
    }

    public User getUser(String email) {
        Query<User> query = getSession().createQuery("from User u where u.email=:email", User.class);
        /*"from User u where u.username=" + username*/
        query.setParameter("email", email.trim());
        return query.uniqueResult();
    }
    
    public void delete(User u) throws AthletoException {
    	begin();
    	getSession().delete(u);
    	commit();
    }
}