package com.fis.training.repository.jpa;

import com.fis.training.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage,Long> {
}
