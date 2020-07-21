package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.ReplacementUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementRepository extends JpaRepository<ReplacementUnit, Integer> {
    ReplacementUnit findById(int replacementId);
}
