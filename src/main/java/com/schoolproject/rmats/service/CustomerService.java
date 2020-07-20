package com.schoolproject.rmats.service;

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
    private final ReplacementRepository replacementRepository;

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
        this.replacementRepository = replacementRepository;
    }

    @Transactional
    public void createCustomer(Customer customer) {
        log.info("action=createCustomerStart, lastName={}, email={}", customer.getLastName(), customer.getEmail());
        customerRepository.save(customer);
        log.info("action=createCustomerEnd");
    }

    @Transactional
    public void createTicket(Ticket ticket) {
        log.info("action=createTicketStart, raiseDate={}, customerComment={}", ticket.getRaiseDate(), ticket.getComment());
        ticketRepository.save(ticket);
        log.info("action=createTicketEnd");
    }

    public List<Ticket> getAllTickets(int userId){
        return ticketRepository.findByUserId(userId);
    }

    @Transactional
    public void createFaulty(FaultyUnit faultyUnit) {
        log.info("action=createFaultyStart,  model={}",  faultyUnit.getModel());

        faultyUnitRepository.save(faultyUnit);
        /*
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (!ticket.isPresent() || !Objects.equals(ticket.get().getUserId(), userId)) {
            throw new IllegalArgumentException("ticket not found");
        }
        Ticket ticketEntity = ticket.get();
        FaultyUnit savedFaulty = faultyUnitDAO.save(faultyUnit);
        //ticketEntity.setFaultyUnitId(savedFaulty.getId());
        ticketRepository.save(ticketEntity);
         */
        log.info("action=createTicketEnd");
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

    @Transactional
    public void addAuthorization(Authorization authorization){
        authorizationRepository.save(authorization);
    }

    @Transactional
    public void createReplacementUnit(ReplacementUnit replacementUnit){
        replacementRepository.save(replacementUnit);
    }
}
