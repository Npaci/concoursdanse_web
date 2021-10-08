package com.pngabo.demo.dataaccess.repositories;

import com.pngabo.demo.dataaccess.entities.Concours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcoursRepository extends JpaRepository<Concours, Long> {
}
