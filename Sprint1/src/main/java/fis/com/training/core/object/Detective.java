package fis.com.training.core.object;

import fis.com.training.core.enums.EmploymentStatus;
import fis.com.training.core.enums.Rank;

import java.util.Set;

public class Detective {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;
}
