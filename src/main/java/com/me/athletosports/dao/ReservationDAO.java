package com.me.athletosports.dao;

import com.me.athletosports.exception.AthletoException;
import com.me.athletosports.pojo.Reservation;
import com.me.athletosports.pojo.User;
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


    public List<Reservation> list(Boolean isAdmin, long userId) {
        String adminQuery = "FROM Reservation"; /*fetch all reservations*/
        String userQuery = "FROM Reservation u where u.user_id=:user_id"; /*fetch only email corresponding reservations*/
        Query<Reservation> query = getSession().createQuery(isAdmin ? adminQuery : userQuery, Reservation.class);
        if (!isAdmin) {
            query.setParameter("user_id", userId);
        }
        List<Reservation> list = query.getResultList();
        return list;
    }
}
