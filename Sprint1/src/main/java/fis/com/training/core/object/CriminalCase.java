package fis.com.training.core.object;

import fis.com.training.core.enums.CaseStatus;
import fis.com.training.core.enums.CaseType;

import java.util.Set;

public class CriminalCase {
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator;
    private Set<Detective> assigned;
}
