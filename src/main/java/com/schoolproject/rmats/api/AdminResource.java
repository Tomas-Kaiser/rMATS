package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.to.ReplacementTO;
import com.schoolproject.rmats.model.ReplacementUnit;
import com.schoolproject.rmats.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminResource {
    public static final Logger log = LogManager.getLogger(AdminResource.class);

    public final AdminService adminService;

    @Autowired
    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public String admin(){
        return ("<h1>This is for admin!</h1>");
    }

    @Validated
    @PostMapping("/replacement")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReplacementUnits(@Valid @NotNull @RequestBody ReplacementTO replacementUnit
    ){
    // TODO: Refactor the code below into private method
        log.info("action=PostReplacementUnit, receive/model, model={} ", replacementUnit.getModel());
        ReplacementUnit entity = new ReplacementUnit();
        entity.setTicketId(replacementUnit.getTicketId());
        entity.setProcessed(false);
        entity.setStatus("In progress");
        entity.setCarrier(replacementUnit.getCarrier());
        entity.setModel(replacementUnit.getModel());
        entity.setNewSerialNumber(replacementUnit.getNewSerialNumber());
        entity.setTrackingNumber(replacementUnit.getTrackingNumber());
        entity.setComment(replacementUnit.getComment());
        adminService.createReplacementUnit(entity);
        log.info("action=PostReplacementUnitEnd");
    }

    @Validated
    @PutMapping("/{replacementId:\\d+}/replacement")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateReplacementUnit(@PathVariable(name = "replacementId") int replacementId, @Valid @NotNull @RequestBody ReplacementTO replacementUnit){
        // TODO: Refactor the code below into private method
        log.info("action=UpdatateReplacementUnit, receive/model, model={} ", replacementUnit.getModel());
        ReplacementUnit entity = new ReplacementUnit();
        entity.setTicketId(replacementUnit.getTicketId());
        entity.setProcessed(replacementUnit.getProcessed());
        entity.setStatus(replacementUnit.getStatus());
        entity.setCarrier(replacementUnit.getCarrier());
        entity.setModel(replacementUnit.getModel());
        entity.setNewSerialNumber(replacementUnit.getNewSerialNumber());
        entity.setTrackingNumber(replacementUnit.getTrackingNumber());
        entity.setComment(replacementUnit.getComment());
        log.info("action=UpdatateReplacementUnitEnd, receive/model, model={} ", replacementUnit.getModel());
        adminService.updateReplacementUnit(entity, replacementId);
    }

}
