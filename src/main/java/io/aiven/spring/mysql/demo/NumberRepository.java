package io.aiven.spring.mysql.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aiven.spring.mysql.demo.NumberEntity;

public interface NumberRepository extends JpaRepository<NumberEntity, Long> {
}
