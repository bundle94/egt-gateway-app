package com.egt.gateway.dto.repository;

import com.egt.gateway.dto.model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Sessions, Long> {
    Optional<Sessions> findByRequestId(String requestId);
}
