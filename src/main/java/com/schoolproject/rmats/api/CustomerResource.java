package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.rt.FaultyRT;
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
    public void createCustomer(@Valid @NotNull @RequestBody CustomerTO customer) {
        log.info("action=createCustomerStart, receive=/customer, method=POST, company={}", customer.getCompany());
        Customer entity = convertToEntity(customer);
        customerService.createCustomer(entity);
        log.info("action=createCustomerEnd");

        log.info("action=createCustomer&AddingAuthorizationStart, receive=/customer, method=POST, email={}", customer.getEmail());
        // TODO: Refactor the below code!
        Authorization entityAuth = new Authorization();
        entityAuth.setAuthority("ROLE_CUSTOMER");
        entityAuth.setEmail(customer.getEmail());
        customerService.addAuthorization(entityAuth);
        log.info("action=createCustomer&AddingAuthorizationEnd");
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

    // Creating a new ticket
    @Validated
    @PostMapping("/customers/{id:\\d+}/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTicket(@PathVariable(name = "id") int customerId, @Valid @NotNull @RequestBody TicketTO ticket) {
        log.info("action=createTicket, receive=customerId/ticket, method=POST, custComment={}", ticket.getCustComment());
        Ticket entity = convertToEntity(ticket, customerId);
        customerService.createTicket(entity);
        log.info("action=createTicketEnd");
    }

    private Ticket convertToEntity(TicketTO ticket, int customerId){
        Ticket entity = new Ticket();
        entity.setRaiseDate(ticket.getRaiseDate());
        entity.setComment(ticket.getCustComment());
        entity.setUserId(customerId);
        return entity;
    }

    // Get all Tickets
    @GetMapping("/customers/{id:\\d+}/tickets")
    public List<Ticket> getAllTickets(@PathVariable(name = "id") int customerId) {
        return customerService.getAllTickets(customerId);
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
    @GetMapping("/customers/{id:\\d+}/tickets/{ticketId:\\d+}/faulty")
    public List<FaultyUnit> getFaulty(@PathVariable(name = "id") int customerId,
                                @PathVariable(name = "ticketId") int ticketId) {

        return customerService.getAllFaultyUnits(ticketId);
    }

    // Adding a new address
    @Validated
    @PostMapping("/customers/{id:\\d+}/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@PathVariable(name = "id") int customerId,
                           @Valid @NotNull @RequestBody AddressTO address) {
        log.info("action=createAddress, receive=customerId/address, method=POST, city={}", address.getCity());
        Address entity = convertToEntity(address, customerId);
        customerService.addAddress(entity);
        log.info("action=createAddressEnd");
    }

    private Address convertToEntity(AddressTO address, int customerId){
        Address entity = new Address();
        entity.setStreet(address.getStreet());
        entity.setZipCode(address.getZipCode());
        entity.setCity(address.getCity());
        entity.setCountry(address.getCountry());
        entity.setUserId(customerId);
        return entity;
    }

    // Getting an address
    @GetMapping("/customers/{id:\\d+}/address")
    public List<Address> getAllAddresses(@PathVariable(name = "id") int customerId){
        return customerService.getAllAddresses(customerId);
    }

    // Set up an authorization
    @Validated
    @PostMapping("/customers/authorization")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthorization(@RequestBody AuthorizationTO authorization){
// TODO: Refactor the code below into private method
        log.info("action=addAuthority, receive/authorization, email={}", authorization.getEmail());
        Authorization entity = new Authorization();
        entity.setAuthority(authorization.getAuthority());
        entity.setEmail(authorization.getEmail());
        customerService.addAuthorization(entity);
        log.info("action=addAuthorityEnd");
    }
}
