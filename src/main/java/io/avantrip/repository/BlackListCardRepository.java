package io.avantrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.avantrip.domain.BlackListCardEntity;;

public interface BlackListCardRepository extends JpaRepository<BlackListCardEntity, Long> {
}