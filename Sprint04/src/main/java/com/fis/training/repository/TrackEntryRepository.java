package com.fis.training.repository;

import com.fis.training.model.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackEntryRepository extends JpaRepository<TrackEntry,Long> {
}
