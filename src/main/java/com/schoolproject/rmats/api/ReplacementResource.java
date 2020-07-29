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
    public static final Logger log = LogManager.getLogger(CustomerResource.class);
    private final ReplacementService replacementService;

    @Autowired
    public ReplacementResource(ReplacementService replacementService) {
        this.replacementService = replacementService;
    }

    // Get Replacement unit detail
    @GetMapping("/{ticketId:\\d+}/replacements")
    public List<ReplacementUnit> getReplacement(@PathVariable(name = "ticketId") int ticketId){
        log.info("action=getReplacementStart");
        log.info("action=getReplacementEnd");
        return replacementService.getReplacement(ticketId);
    }
}
