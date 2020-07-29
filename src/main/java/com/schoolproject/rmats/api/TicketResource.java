package com.schoolproject.rmats.api;

import com.schoolproject.rmats.model.Ticket;
import com.schoolproject.rmats.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TicketResource {

    private final TicketService ticketService;

    @Autowired
    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Get all tickets by user
    @GetMapping("/{customerId:\\d+}/tickets")
    public List<Ticket> getAllTicketsByUserId(@PathVariable(name = "customerId") int customerId) {
        return ticketService.getAllticketsByUserId(customerId);
    }

    // Get all tickets
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
