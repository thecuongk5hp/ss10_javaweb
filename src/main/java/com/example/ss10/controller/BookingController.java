package com.example.ss10.controller;

import com.example.ss10.model.Seat;
import com.example.ss10.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BookingController {

    @GetMapping("bai8")
    public String showFormBooking() {
        return "bookingForm";
    }

    @PostMapping("booking")
    public String bookTicket(@RequestParam String movieTitle,
                             @RequestParam String showTime,
                             @RequestParam List<String> selectedSeats,
                             Model model) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date parsedDate = sdf.parse(showTime);

            List<Seat> seats = new ArrayList<>();
            for (String seatNum : selectedSeats) {
                seats.add(new Seat(seatNum));
            }

            double totalAmount = seats.size() * 5.0;

            Ticket ticket = new Ticket(movieTitle, parsedDate, seats, totalAmount);
            model.addAttribute("ticket", ticket);
            return "bookingResult";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid date format!");
            return "bookingForm";
        }
    }
}
