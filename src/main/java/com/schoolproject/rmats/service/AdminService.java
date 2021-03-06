package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.ReplacementRepository;
import com.schoolproject.rmats.dao.TicketRepository;
import com.schoolproject.rmats.model.ReplacementUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class AdminService {
    private final ReplacementRepository replacementRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public AdminService(ReplacementRepository replacementRepository, TicketRepository ticketRepository) {
        this.replacementRepository = replacementRepository;
        this.ticketRepository = ticketRepository;
    }

    // Create a repalcement unit
    @Transactional
    public void createReplacementUnit(ReplacementUnit replacementUnit){
        replacementRepository.save(replacementUnit);
    }

    // Update a replacement unit
    @Transactional
    public void updateReplacementUnit(ReplacementUnit replacementUnitUpdate, int replacementId){
        ReplacementUnit replacementUnit = replacementRepository.findById(replacementId);
        replacementUnit = createReplacementUnit(replacementUnitUpdate, replacementUnit);
        replacementRepository.save(replacementUnit);
    }

    private ReplacementUnit createReplacementUnit(ReplacementUnit replacementUnitUpdate, ReplacementUnit replacementUnit){
        replacementUnit.setComment(replacementUnitUpdate.getComment());
        replacementUnit.setNewSerialNumber(replacementUnitUpdate.getNewSerialNumber());
        replacementUnit.setModel(replacementUnitUpdate.getModel());
        replacementUnit.setCarrier(replacementUnitUpdate.getCarrier());
        replacementUnit.setStatus(replacementUnitUpdate.getStatus());
        replacementUnit.setTrackingNumber(replacementUnitUpdate.getTrackingNumber());
        return  replacementUnit;
    }
}
