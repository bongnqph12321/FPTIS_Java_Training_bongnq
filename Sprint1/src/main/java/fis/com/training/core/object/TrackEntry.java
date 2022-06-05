package fis.com.training.core.object;

import fis.com.training.core.enums.TrackAction;

import java.time.LocalDateTime;

public class TrackEntry {
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String reason;
}
