package com.pngabo.demo.dataaccess.repositories;

import com.pngabo.demo.dataaccess.entities.Jury;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuryRepository extends JpaRepository<Jury, Long> {
}
