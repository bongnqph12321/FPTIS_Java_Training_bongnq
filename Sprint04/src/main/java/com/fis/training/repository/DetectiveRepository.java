package com.fis.training.repository;

import com.fis.training.model.Detective;
import com.fis.training.model.core.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective,Long> {
        Detective findByRank(Rank rank);
}
