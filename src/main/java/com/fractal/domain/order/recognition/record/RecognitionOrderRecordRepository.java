package com.fractal.domain.order.recognition.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecognitionOrderRecordRepository extends JpaRepository<RecognitionOrderRecord, Long> {

    List<RecognitionOrderRecord> findAllByRecognitionOrderId(Long orderId);

    Optional<RecognitionOrderRecord> findByRecognitionOrderIdAndId(Long orderId, Long id);
}
