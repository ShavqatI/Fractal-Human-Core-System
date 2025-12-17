package com.fractal.domain.order.recognition;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RecognitionOrderRepository extends JpaRepository<RecognitionOrder, Long> {


}
