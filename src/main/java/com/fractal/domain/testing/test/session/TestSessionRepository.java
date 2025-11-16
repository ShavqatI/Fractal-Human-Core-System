package com.fractal.domain.testing.test.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TestSessionRepository extends JpaRepository<TestSession, Long> {

}
