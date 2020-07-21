package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.ReplacementRepository;
import com.schoolproject.rmats.model.ReplacementUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {
    private final ReplacementRepository replacementRepository;

    @Autowired
    public AdminService(ReplacementRepository replacementRepository) {
        this.replacementRepository = replacementRepository;
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
}
