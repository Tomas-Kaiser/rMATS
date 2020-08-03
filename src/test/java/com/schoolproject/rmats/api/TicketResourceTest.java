package com.schoolproject.rmats.api;

import com.schoolproject.rmats.model.Ticket;
import com.schoolproject.rmats.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketResourceTest {

    @InjectMocks
    TicketResource ticketResource;

    @Mock
    TicketService ticketService;

    List<Ticket> tickets = new ArrayList<>();

    final Integer userId = 1;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setUserId(userId);
        ticket.setComment("This is a comment");
        ticket.setRaiseDate(new Date());
        System.out.println(ticket.toString());
        tickets.add(ticket);
    }

    @Test
    void getAllTicketsByUserId(){
        Mockito.when(ticketService.getAllticketsByUserId(Mockito.anyInt())).thenReturn(tickets);

        List<Ticket> ticketsRest = ticketResource.getAllTicketsByUserId(userId);

        assertNotNull(ticketsRest);

        for (Ticket ticketRest : ticketsRest) {
            assertEquals(userId, ticketRest.getUserId());
            assertEquals(tickets.get(0).getComment(), ticketRest.getComment());
            assertEquals(tickets.get(0).getUserId(), ticketRest.getUserId());
        }
    }
}
