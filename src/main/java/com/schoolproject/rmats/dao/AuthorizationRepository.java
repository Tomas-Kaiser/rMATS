package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization, Integer> {
    Authorization findByEmail(String email);
}
