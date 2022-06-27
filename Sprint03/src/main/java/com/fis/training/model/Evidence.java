package com.fis.training.model;




import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "evidence")
public class Evidence extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "criminal_case_id")
    private CriminalCase criminalCase;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    private String number;
    private String itemName;
    //very big text
    private String notes;
    private Boolean archived = false;
    @OneToMany(mappedBy = "evidence")
    private Set<TrackEntry> trackEntries = new HashSet<>();


}
