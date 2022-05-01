package com.me.athletosports.controller;

import com.me.athletosports.dao.ReservationDAO;
import com.me.athletosports.exception.AthletoException;
import com.me.athletosports.pojo.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;


@Controller
public class ReservationController {

    // Create Reservation
    @GetMapping("/reservation.htm")
    public String makeReservationGet() {
        return "reservationForm";
    }

    @PostMapping("/reservation.htm")
    public ModelAndView makeReservationPost(HttpServletRequest request, ReservationDAO reservationDAO) {
        /*
        Reservation reservation = new Reservation();
        reservation.setUser_id(45678765);// to be set from current session
        reservation.setDate(Date.valueOf(request.getParameter("checkin-date"));
        reservation.setSlot(request.getParameter("slot-selection"));
        reservation.setSportType(request.getParameter("sporttype-selection"));
        try {
            reservationDAO.save(reservation);
        } catch (AthletoException e) {
            System.out.println("Reservation cannot be Added: " + e.getMessage());
        }
        */
        /*Redirect to home screen*/
        return new ModelAndView("redirect:/reservations.htm");
    }

    // Fetch Reservations
    @GetMapping("/listreservations.htm")
    public String listAdvertsGet(HttpServletRequest request, ReservationDAO reservationDAO) {
        List<Reservation> reservations = reservationDAO.list();
        request.setAttribute("reservations", reservations);
        System.out.println("Did fetch total " + String.valueOf(reservations.size()));
        return "viewreservations";
    }

}
