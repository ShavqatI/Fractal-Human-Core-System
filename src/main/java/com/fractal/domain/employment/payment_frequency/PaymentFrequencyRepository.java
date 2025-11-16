package com.fractal.domain.employment.payment_frequency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PaymentFrequencyRepository extends JpaRepository<PaymentFrequency, Long> {
    Optional<PaymentFrequency> findById(Long id);

    Optional<PaymentFrequency> findByCode(String code);

    List<PaymentFrequency> findAll();
}
