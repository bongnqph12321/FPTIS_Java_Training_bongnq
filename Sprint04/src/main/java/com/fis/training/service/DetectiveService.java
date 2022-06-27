package com.fis.training.service;

import com.fis.training.model.Detective;

import java.util.List;

public interface DetectiveService {
    Detective findById(Long id);
    Detective createDetective(Detective detective);
    Detective updateDetective(Detective detective);
    void deleteDetectiveById(Long detectiveId);
    List<Detective> findAll();
}
