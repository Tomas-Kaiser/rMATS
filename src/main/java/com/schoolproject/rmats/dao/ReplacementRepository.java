package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.ReplacementUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplacementRepository extends JpaRepository<ReplacementUnit, Integer> {
    List<ReplacementUnit> findByTicketId(int ticketId);

    ReplacementUnit findById(int replacementId);
}
