package com.fis.training.service.impl;

import com.fis.training.model.Detective;
import com.fis.training.model.TrackEntry;
import com.fis.training.service.TrackEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackEntryImpl implements TrackEntryService {
    @Override
    public TrackEntry findById(Long id) {
        return null;
    }

    @Override
    public void createTrackEntry(TrackEntry trackEntry) {

    }

    @Override
    public Detective updateTrackEntry(TrackEntry trackEntry) {
        return null;
    }

    @Override
    public void deleteTrackEntryById(Long trackEntryId) {

    }

    @Override
    public List<TrackEntry> findAll() {
        return null;
    }
}
