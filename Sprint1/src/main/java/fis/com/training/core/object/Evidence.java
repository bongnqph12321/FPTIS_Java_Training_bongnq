package fis.com.training.core.object;

import java.util.Set;

public class Evidence {
    private CriminalCase criminalCase;
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private boolean archived;
    private Set<TrackEntry> trackEntries;
}
