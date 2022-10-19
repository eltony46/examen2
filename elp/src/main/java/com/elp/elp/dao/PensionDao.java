package com.elp.elp.dao;

import com.elp.elp.models.Pension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensionDao extends JpaRepository<Pension, Long> {
}
