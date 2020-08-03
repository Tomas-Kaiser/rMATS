package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.to.ReplacementTO;
import com.schoolproject.rmats.model.Customer;
import com.schoolproject.rmats.model.ReplacementUnit;
import com.schoolproject.rmats.service.AdminService;
import com.schoolproject.rmats.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminResource {
    public static final Logger log = LogManager.getLogger(AdminResource.class);

    public final AdminService adminService;
    public final CustomerService customerService;

    @Autowired
    public AdminResource(AdminService adminService, CustomerService customerService) {
        this.adminService = adminService;
        this.customerService = customerService;
    }

    // Get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // Create a replacement unit
    @Validated
    @PostMapping("/replacement")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReplacementUnits(@Valid @NotNull @RequestBody ReplacementTO replacementUnit
    ){
        log.info("action=PostReplacementUnit, receive/model, model={} ", replacementUnit.getModel());
        ReplacementUnit entity = convertToEntity(replacementUnit);
        adminService.createReplacementUnit(entity);
        log.info("action=PostReplacementUnitEnd");
    }

    // Updating of replacement unit
    @Validated
    @PutMapping("/{replacementId:\\d+}/replacement")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateReplacementUnit(@PathVariable(name = "replacementId") int replacementId, @Valid @NotNull @RequestBody ReplacementTO replacementUnit){
        log.info("action=UpdatateReplacementUnit, receive/model, model={} ", replacementUnit.getModel());
        ReplacementUnit entity = convertToEntity(replacementUnit);
        log.info("action=UpdatateReplacementUnitEnd, receive/model, model={} ", replacementUnit.getModel());
        adminService.updateReplacementUnit(entity, replacementId);
    }

    private ReplacementUnit convertToEntity(ReplacementTO replacementUnit){
        ReplacementUnit entity = new ReplacementUnit();
        entity.setTicketId(replacementUnit.getTicketId());
        entity.setStatus(replacementUnit.getStatus());
        entity.setCarrier(replacementUnit.getCarrier());
        entity.setModel(replacementUnit.getModel());
        entity.setNewSerialNumber(replacementUnit.getNewSerialNumber());
        entity.setTrackingNumber(replacementUnit.getTrackingNumber());
        entity.setComment(replacementUnit.getComment());
        return entity;
    }

}
