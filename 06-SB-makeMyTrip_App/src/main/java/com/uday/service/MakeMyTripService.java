package com.uday.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uday.binding.Passenger;
import com.uday.binding.Ticket;
/*
 * @Service public class MakeMyTripService {
 * 
 * public Ticket bookTicket(Passenger p) {
 * 
 * // to give our IRCTC Aws link (http://43.205.144.253) with post method url as
 * // /tickets (8080/ticket)
 * 
 * String apiUrl = "http://43.205.144.253:8080/ticket"; // without Aws link
 * giving direct link but not working String apiUrl = // "/tickets";
 * 
 * // String apiUrl = "/tickets"; // in sping we can develop consumer in 3 wasy
 * first was using RestTemplate(out // dated)
 * 
 * RestTemplate rt = new RestTemplate();
 * 
 * // pre defined method in rest template to do post method
 * 
 * ResponseEntity<Ticket> forEntity = rt.postForEntity(apiUrl, p, Ticket.class);
 * 
 * // to get body
 * 
 * Ticket body = forEntity.getBody(); return body; }
 * 
 * // to get all tickets list public List<Ticket> getAllTickets() {
 * 
 * // to give our IRCTC Aws link (http://43.205.144.253) with post method url as
 * // /tickets (8080/ticket)
 * 
 * // String apiUrl = "http://43.205.144.253:8080/tickets"; // without Aws link
 * giving direct link but not working String apiUrl = // "/tickets"; // object
 * creation
 * 
 * String apiUrl = "/tickets";
 * 
 * RestTemplate rt = new RestTemplate();
 * 
 * // in sping we can develop consumer in 3 wasy first was using
 * RestTemplate(out // dated) with get method with inputs url and respose class
 * // we take as Ticket[] bcz more than one tickets .class
 * 
 * ResponseEntity<Ticket[]> forEntity = rt.getForEntity(apiUrl, Ticket[].class);
 * 
 * Ticket[] body = forEntity.getBody();
 * 
 * // converting tickets jason to object
 * 
 * List<Ticket> tickets = Arrays.asList(body);
 * 
 * return tickets;
 * 
 * }
 * 
 * }
 */

@Service
public class MakeMyTripService {
	
	public Ticket bookTicket(Passenger p) {
		
		String apiUrl = "http://43.205.144.253:8080/ticket";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Ticket> forEntity = 
				rt.postForEntity(apiUrl, p, Ticket.class);
		
		Ticket body = forEntity.getBody();
		return body;
	}
	
	public List<Ticket> getAllTickets(){
		
		String apiUrl = "http://43.205.144.253:8080/tickets";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Ticket[]> forEntity =
				rt.getForEntity(apiUrl, Ticket[].class);
		
		Ticket[] body = forEntity.getBody();
		
		List<Ticket> tickets = Arrays.asList(body);
		
		return tickets;
		
	}

}