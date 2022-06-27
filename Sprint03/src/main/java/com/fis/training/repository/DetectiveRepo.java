package com.fis.training.repository;

import com.fis.training.core.Rank;
import com.fis.training.model.Detective;


import java.util.Optional;
import java.util.Set;

public interface DetectiveRepo extends AbstractRepo<Detective> {
    Detective save(Detective detective);
    Set<Detective> findAll();
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    Set<Detective> findbyRank(Rank rank);

    default Optional<Detective> findByIdWithPersonDetails(Long id) {
        return Optional.empty();
    }


}