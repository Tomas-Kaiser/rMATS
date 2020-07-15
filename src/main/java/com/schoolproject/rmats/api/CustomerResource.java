package com.schoolproject.rmats.api;

import com.schoolproject.rmats.model.Address;
import com.schoolproject.rmats.model.FaultyUnit;
import com.schoolproject.rmats.model.Ticket;
import com.schoolproject.rmats.service.CustomerService;
import com.schoolproject.rmats.model.Customer;
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

@RequestMapping("/customer")
@RestController
public class CustomerResource {

    public static final Logger log = LogManager.getLogger(CustomerResource.class);
    private final CustomerService customerService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Validated
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@Valid @NotNull @RequestBody CustomerTO customer) {
        log.info("action=createCustomerStart, receive=/customer, method=POST, company={}", customer.getCompany());
        Customer entity = convertToEntity(customer);
        customerService.createCustomer(entity);
        log.info("action=createCustomerEnd");
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

    @Validated
    @PostMapping("/{id:\\d+}/ticket")
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

    @GetMapping("/{id:\\d+}/tickets")
    public List<Ticket> getAllTickets(@PathVariable(name = "id") int customerId) {
        return customerService.getAllTickets(customerId);
    }

    @Validated
    @PostMapping("/{id:\\d+}/tickets/{ticketId:\\d+}/faulty")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFaulty(@PathVariable(name = "id") int customerId,
                             @PathVariable(name = "ticketId") int ticketId,
                             @Valid @NotNull @RequestBody FaultyTO faultyUnit
    ) {
        log.info("action=createFaultyUnit, receive=customerId/ticketId/FaultyUnit, method=POST, serialNumber={}", faultyUnit.getSerialNumber());
        FaultyUnit entity = convertToEntity(faultyUnit, ticketId);
        customerService.createFaulty(entity);
        log.info("action=createFaultyUnitEnd");
    }

    private FaultyUnit convertToEntity(FaultyTO faultyUnit, int ticketId){
        FaultyUnit entity = new FaultyUnit();
        entity.setTicketId(faultyUnit.getTicketId());
        entity.setModel(faultyUnit.getModel());
        entity.setSerialNumber(faultyUnit.getSerialNumber());
        return entity;
    }

    @GetMapping("/{id:\\d+}/tickets/{ticketId:\\d+}/faulty")
    public List<FaultyUnit> getFaulty(@PathVariable(name = "id") int customerId,
                                @PathVariable(name = "ticketId") int ticketId) {

        return customerService.getAllFaultyUnits(ticketId);
    }

    @Validated
    @PostMapping("/{id:\\d+}/address")
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

    @GetMapping("/{id:\\d+}/address")
    public List<Address> getAllAddresses(@PathVariable(name = "id") int customerId){
        return customerService.getAllAddresses(customerId);
    }
}
