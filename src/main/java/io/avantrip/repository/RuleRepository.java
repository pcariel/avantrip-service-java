package io.avantrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.avantrip.domain.RuleEntity;

public interface RuleRepository extends JpaRepository<RuleEntity, Long> {
    List<RuleEntity> findByActiveTrue();
}