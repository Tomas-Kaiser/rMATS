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
import java.util.List;

@Service
public class CustomerService {

    private static final Logger log = LogManager.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final FaultyUnitRepository faultyUnitRepository;
    private final AddressRepository addressRepository;
    private final AuthorizationRepository authorizationRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           TicketRepository ticketRepository,
                           FaultyUnitRepository faultyUnitRepository,
                           AddressRepository addressRepository,
                           AuthorizationRepository authorizationRepository,
                           ReplacementRepository replacementRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.faultyUnitRepository = faultyUnitRepository;
        this.addressRepository = addressRepository;
        this.authorizationRepository = authorizationRepository;
    }

    @Transactional
    public void createCustomer(Customer customer) {
        log.info("action=createCustomerStart, lastName={}, email={}", customer.getLastName(), customer.getEmail());
        customerRepository.save(customer);
        log.info("action=createCustomerEnd");
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
        // TODO: Refactor the below code
        log.info("action=createFaultyRTStart");
        FaultyRT faultyRT = new FaultyRT();
        faultyRT.setId(faultyUnit.getId());
        faultyRT.setModel(faultyUnit.getModel());
        faultyRT.setSerialNumber((faultyUnit.getSerialNumber()));
        log.info("action=createFaultyRTEND");

        return faultyRT;
    }

    public List<FaultyUnit> getAllFaultyUnits(int ticketId) {
        return faultyUnitRepository.findByTicketId(ticketId);
    }

    @Transactional
    public void addAddress(Address address){
        addressRepository.save(address);
    }

    public List<Address> getAllAddresses(int customerId){
        return addressRepository.findByUserId(customerId);
    }

    public void deleteAddressById(int customerId){
        addressRepository.deleteById(customerId);
    }

    @Transactional
    public void addAuthorization(Authorization authorization){
        authorizationRepository.save(authorization);
    }



}
