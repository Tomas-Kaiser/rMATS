package com.schoolproject.rmats.service;

import com.schoolproject.rmats.api.rt.FaultyRT;
import com.schoolproject.rmats.api.rt.TicketRT;
import com.schoolproject.rmats.dao.*;
import com.schoolproject.rmats.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger log = LogManager.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final FaultyUnitRepository faultyUnitRepository;
    private final AuthorizationRepository authorizationRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           TicketRepository ticketRepository,
                           FaultyUnitRepository faultyUnitRepository,
                           AuthorizationRepository authorizationRepository,
                           ReplacementRepository replacementRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.faultyUnitRepository = faultyUnitRepository;
        this.authorizationRepository = authorizationRepository;
    }

    @Transactional
    public void createCustomer(Customer customer) {
        log.info("action=createCustomerStart, lastName={}, email={}", customer.getLastName(), customer.getEmail());
        customerRepository.save(customer);
        log.info("action=createCustomerEnd");
    }

    public Customer getCustomerById(int customerId){
        return customerRepository.findById(customerId);
    }

    public TicketRT createTicket(Ticket ticket) {
        log.info("action=createTicketStart, raiseDate={}, customerComment={}", ticket.getRaiseDate(), ticket.getComment());
        ticketRepository.save(ticket);
        log.info("action=createTicketEnd");

        // TODO: Refactor the below code
        TicketRT ticketRT = new TicketRT();
        ticketRT.setId(ticket.getId());
        ticketRT.setComment(ticket.getComment());
        return ticketRT;
    }



    @Transactional
    public FaultyRT createFaulty(FaultyUnit faultyUnit) {
        log.info("action=createFaultyStart,  model={}",  faultyUnit.getModel());
        faultyUnitRepository.save(faultyUnit);
        log.info("action=createTicketEnd");

        log.info("action=createFaultyRTStart");
        FaultyRT faultyRT = createFaultyRT(faultyUnit);
        log.info("action=createFaultyRTEND");

        return faultyRT;
    }

    private FaultyRT createFaultyRT(FaultyUnit faultyUnit){
        FaultyRT faultyRT = new FaultyRT();
        faultyRT.setId(faultyUnit.getId());
        faultyRT.setModel(faultyUnit.getModel());
        faultyRT.setSerialNumber((faultyUnit.getSerialNumber()));
        return faultyRT;
    }

    public List<FaultyUnit> getAllFaultyUnits(int ticketId) {
        return faultyUnitRepository.findByTicketId(ticketId);
    }


    @Transactional
    public void addAuthorization(Authorization authorization){
        authorizationRepository.save(authorization);
    }

    // Get all customers
    public List<Customer> getAllCustomers(){
        // Getting all users registered as admin or customer
        List<Customer> users = customerRepository.findAll();

        List<Customer> customers = new ArrayList<Customer>();
        // Select only the users who has customer role
        for (Customer u : users) {
            Authorization auth = authorizationRepository.findByEmail(u.getEmail());
            if (auth.getAuthority().equals("ROLE_CUSTOMER")){
                customers.add(u);
            }
        }
        return customers;
    }



}
