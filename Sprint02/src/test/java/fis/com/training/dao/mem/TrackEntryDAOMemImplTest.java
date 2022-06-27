package fis.com.training.dao.mem;

import fis.com.training.core.enums.TrackAction;
import fis.com.training.core.object.TrackEntry;
import fis.com.training.dao.IDetectiveDAO;
import fis.com.training.dao.IEvidenceDAO;
import fis.com.training.dao.ITrackEntryDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackEntryDAOMemImplTest {

    @Test
    void save() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();
        IDetectiveDAO d = new DetectiveDAOMemImpl();
        ITrackEntryDAO te = new TrackEntryDAOMemImpl();
        TrackEntry track = new TrackEntry(4l,0021, LocalDateTime.now(), e.getEvidenceById(1l), d.getDetectiveById(1l), TrackAction.RETRIEVED, "ABCNAHNJOWO");

        te.save(track);

        long id = track.getId();

        assertEquals(4L,id);
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        ITrackEntryDAO te = new TrackEntryDAOMemImpl();

        List<TrackEntry> list = te.getAll();

        assertEquals(3,list.size());
    }

    @Test
    void update() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();
        IDetectiveDAO d = new DetectiveDAOMemImpl();
        ITrackEntryDAO te = new TrackEntryDAOMemImpl();
        TrackEntry track = new TrackEntry(4l,0021,LocalDateTime.now(), e.getEvidenceById(2l), d.getDetectiveById(2l), TrackAction.RETRIEVED, "ABCNAHNJOWO");

        te.update(track);
        int version = track.getVersion();

        assertEquals(0021,version);
    }

    @Test
    void delete() {
        ITrackEntryDAO te = new TrackEntryDAOMemImpl();

        te.delete(3L);

        assertNotEquals(3L,te.getTrackEntryById(3L));
    }
}