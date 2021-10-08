package com.pngabo.demo.dataaccess.repositories;

import com.pngabo.demo.dataaccess.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
