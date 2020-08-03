package com.schoolproject.rmats.api;

import com.schoolproject.rmats.model.ReplacementUnit;
import com.schoolproject.rmats.service.ReplacementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ReplacementResource {
    private final ReplacementService replacementService;

    @Autowired
    public ReplacementResource(ReplacementService replacementService) {
        this.replacementService = replacementService;
    }

    // Get Replacement unit by ticket id
    @GetMapping("/{ticketId:\\d+}/replacements")
    public List<ReplacementUnit> getReplacementUnitByTicketId(@PathVariable(name = "ticketId") int ticketId){
        return replacementService.getReplacementUnitByTicketId(ticketId);
    }

    // Get Replacement unit by id
    @GetMapping("replacements/{replacementId:\\d+}")
    public ReplacementUnit getReplacementUnitById(@PathVariable(name = "replacementId") int replacementId){
        return replacementService.getReplacementUnitById(replacementId);
    }
}
