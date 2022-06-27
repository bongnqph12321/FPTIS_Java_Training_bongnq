package com.fis.training.model;



import com.fis.training.model.core.CaseStatus;
import com.fis.training.model.core.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "criminal")
public class CriminalCase extends AbstractEntity{
    private String number;

    @Enumerated(EnumType.STRING)
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    //very big text
    private String notes;
    @OneToMany(mappedBy = "criminalCase")
    private Set<Evidence> evidenceSet;
    @ManyToOne
    @JoinColumn(name = "lead_investigator", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany(cascade = CascadeType.MERGE)
//    @JsonIgnore
    @JoinTable(
            name="detective_case",
            joinColumns=@JoinColumn(name="case_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"))
    private Set<Detective> assigned = new HashSet<>();

}
