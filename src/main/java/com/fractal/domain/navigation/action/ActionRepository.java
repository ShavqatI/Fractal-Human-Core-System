package com.fractal.domain.navigation.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ActionRepository extends JpaRepository<Action,Long> {
    Optional<Action> findByUrl(String url);
}
