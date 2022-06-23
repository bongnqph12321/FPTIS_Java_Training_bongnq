package com.fresher.repository.jpa;

import com.fresher.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase,Long> {
}
