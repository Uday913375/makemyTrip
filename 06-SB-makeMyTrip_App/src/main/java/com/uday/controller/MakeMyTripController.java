package com.uday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uday.binding.Passenger;
import com.uday.binding.Ticket;
import com.uday.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	// to book the Ticket
	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		Ticket bookTicket = service.bookTicket(p);
		model.addAttribute("msg", "Your Ticket Booked, ID : " + bookTicket.getTicketNum());
		return "bookTicket";
	}

// to display BookTicket page
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passenger());
		return "bookTicket";
	}

// to display the index page
	@GetMapping("/")
	public String index(Model model) {
		List<Ticket> allTickets = service.getAllTickets();
		model.addAttribute("tickets", allTickets);
		return "index";
	}

}