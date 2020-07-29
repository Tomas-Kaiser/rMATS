package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.ReplacementRepository;
import com.schoolproject.rmats.dao.TicketRepository;
import com.schoolproject.rmats.model.ReplacementUnit;
import com.schoolproject.rmats.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    private final ReplacementRepository replacementRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public AdminService(ReplacementRepository replacementRepository, TicketRepository ticketRepository) {
        this.replacementRepository = replacementRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void createReplacementUnit(ReplacementUnit replacementUnit){
        replacementRepository.save(replacementUnit);
    }

    @Transactional
    public void updateReplacementUnit(ReplacementUnit replacementUnitUpdate, int replacementId){
        ReplacementUnit replacementUnit = replacementRepository.findById(replacementId);
        replacementUnit.setComment(replacementUnitUpdate.getComment());
        replacementUnit.setSerialNumber(replacementUnitUpdate.getTrackingNumber());
        replacementUnit.setModel(replacementUnitUpdate.getModel());
        replacementUnit.setCarrier(replacementUnitUpdate.getCarrier());
        replacementUnit.setStatus(replacementUnitUpdate.getStatus());
        replacementUnit.setProcessed(replacementUnitUpdate.getProcessed());
        replacementUnit.setTrackingNumber(replacementUnitUpdate.getTrackingNumber());
        replacementRepository.save(replacementUnit);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
