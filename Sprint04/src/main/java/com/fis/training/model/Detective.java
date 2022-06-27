package com.fis.training.model;




import com.fis.training.model.core.EmploymentStatus;
import com.fis.training.model.core.Rank;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detective")
public class Detective extends AbstractEntity{
    @NotNull
    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    private LocalDateTime hiringDate;
    private String badgeNumber;
    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed = false;
    @Column(name = "status_detective")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status = EmploymentStatus.ACTIVE;

    @ManyToMany(cascade = CascadeType.MERGE)
//    @JsonIgnore
    @JoinTable(
            name = "detective_case",
            joinColumns = @JoinColumn(name = "detective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"))
    private Set<CriminalCase> criminalCases = new HashSet<>();
    @OneToMany(mappedBy = "detective",fetch = FetchType.EAGER)
    private Set<TrackEntry> trackEntries;

}
