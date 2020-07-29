package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.TicketRepository;
import com.schoolproject.rmats.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Get all tickets by user
    public List<Ticket> getAllticketsByUserId(int userId){
        return ticketRepository.findByUserId(userId);
    }

    // Get all tickets
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
