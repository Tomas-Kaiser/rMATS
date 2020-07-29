package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.ReplacementRepository;
import com.schoolproject.rmats.model.ReplacementUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplacementService {
    private final ReplacementRepository replacementRepository;

    @Autowired
    public ReplacementService(ReplacementRepository replacementRepository) {
        this.replacementRepository = replacementRepository;
    }

    // Get Replacement unit by ticket id
    public List<ReplacementUnit> getReplacementUnitByTicketId(int ticketId){
        return replacementRepository.findByTicketId(ticketId);
    }

    // Get Replacement unit by id
    public ReplacementUnit getReplacementUnitById(int replacementId){
        return replacementRepository.findById(replacementId);
    }

}
