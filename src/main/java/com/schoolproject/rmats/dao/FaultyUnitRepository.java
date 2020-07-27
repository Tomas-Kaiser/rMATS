package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.FaultyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaultyUnitRepository extends JpaRepository<FaultyUnit, Integer> {
    List<FaultyUnit> findByTicketId(int ticketId);
    FaultyUnit findBySerialNumber(String serialNumber);
}
