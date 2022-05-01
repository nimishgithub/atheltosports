package com.me.athletosports.dao;

import com.me.athletosports.exception.AthletoException;
import com.me.athletosports.pojo.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationDAO extends DAO {

    public ReservationDAO() {}

    public void save(Reservation reservation) throws AthletoException {
        try {
            begin();
            getSession().save(reservation);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AthletoException("Could not delete booking", e);
        }
    }


    public List<Reservation> list() {
        Query<Reservation> query = getSession().createQuery("FROM Reservation");
        List<Reservation> list = query.list();
        return list;
    }
}
