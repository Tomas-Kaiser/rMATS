package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.rt.FaultyRT;
import com.schoolproject.rmats.api.rt.TicketRT;
import com.schoolproject.rmats.api.to.*;
import com.schoolproject.rmats.model.*;
import com.schoolproject.rmats.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin
@RestController
public class CustomerResource {

    public static final Logger log = LogManager.getLogger(CustomerResource.class);
    private final CustomerService customerService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerResource(CustomerService customerService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerService = customerService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Creating a new customer and assigning a customer role.
    @Validated
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@Valid @NotNull @RequestBody CustomerTO customer) {
        log.info("action=createCustomerStart, receive=/customer, method=POST, company={}", customer.getCompany());
        Customer entity = convertToEntity(customer);
        try{
            customerService.createCustomer(entity);
        } catch (Exception ex){
            return "Customer already created!";
        }
        log.info("action=createCustomerEnd");

        log.info("action=createCustomer&AddingAuthorizationStart, receive=/customer, method=POST, email={}", customer.getEmail());
        Authorization customerAuth = assignAuth(customer);
        customerService.addAuthorization(customerAuth);
        log.info("action=createCustomer&AddingAuthorizationEnd");
        return "Customer created!";
    }

    private Customer convertToEntity(CustomerTO customer) {

        Customer entity = new Customer();
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setCompanyName(customer.getCompany());
        entity.setPhoneNumber(customer.getPhone());
        entity.setEmail(customer.getEmail());
        entity.setEnabled(true);
        entity.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return entity;
    }

    private Authorization assignAuth(CustomerTO customer){
        Authorization entityAuth = new Authorization();
        entityAuth.setAuthority("ROLE_CUSTOMER");
        entityAuth.setEmail(customer.getEmail());
        return entityAuth;
    }

    // Get a customer by id
    @GetMapping("/customer/{id:\\d+}")
    public Customer getCustomerById(@PathVariable(name = "id") int customerId){
        return customerService.getCustomerById(customerId);
    }

    // Creating a new ticket
    @Validated
    @PostMapping("/customers/{id:\\d+}/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TicketRT createTicket(@PathVariable(name = "id") int customerId, @Valid @NotNull @RequestBody TicketTO ticket) {
        log.info("action=createTicket, receive=customerId/ticket, method=POST, custComment={}", ticket.getCustComment());
        Ticket entity = convertToEntity(ticket, customerId);
        log.info("action=createTicketEnd");
        return customerService.createTicket(entity);
    }

    private Ticket convertToEntity(TicketTO ticket, int customerId){
        Ticket entity = new Ticket();
        entity.setRaiseDate(ticket.getRaiseDate());
        entity.setComment(ticket.getCustComment());
        entity.setUserId(customerId);
        return entity;
    }

    // Create a faulty unit
    @Validated
    @PostMapping("/customers/{id:\\d+}/tickets/{ticketId:\\d+}/faulty")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public FaultyRT createFaulty(@PathVariable(name = "id") int customerId,
                                 @PathVariable(name = "ticketId") int ticketId,
                                 @Valid @NotNull @RequestBody FaultyTO faultyUnit
    ) {
        log.info("action=createFaultyUnit, receive=customerId/ticketId/FaultyUnit, method=POST, serialNumber={}", faultyUnit.getSerialNumber());
        FaultyUnit entity = convertToEntity(faultyUnit, ticketId);
        log.info("action=createFaultyUnitEnd");
        return customerService.createFaulty(entity);
    }

    private FaultyUnit convertToEntity(FaultyTO faultyUnit, int ticketId){
        FaultyUnit entity = new FaultyUnit();
        entity.setTicketId(faultyUnit.getTicketId());
        entity.setModel(faultyUnit.getModel());
        entity.setSerialNumber(faultyUnit.getSerialNumber());
        return entity;
    }

    // Get all faulty units
    @GetMapping("/tickets/{ticketId:\\d+}/faulty")
    public List<FaultyUnit> getFaulty(@PathVariable(name = "ticketId") int ticketId) {
        return customerService.getAllFaultyUnits(ticketId);
    }

    // Set up an authorization
    @Validated
    @PostMapping("/customers/authorization")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthorization(@RequestBody AuthorizationTO authorization){
        log.info("action=addAuthority, receive/authorization, email={}", authorization.getEmail());
        Authorization entity = convertToEntity(authorization);
        customerService.addAuthorization(entity);
        log.info("action=addAuthorityEnd");
    }

    private Authorization convertToEntity(AuthorizationTO authorization){
        Authorization entity = new Authorization();
        entity.setAuthority(authorization.getAuthority());
        entity.setEmail(authorization.getEmail());
        return entity;
    }
}
