package com.fractal.domain.navigation.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface MenuRepository extends JpaRepository<Menu,Long> {
    Optional<Menu> findByUrl(String url);
}
