package com.fis.training.model;



import com.fis.training.core.TrackAction;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "trackEntry")
public class TrackEntry extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String reason;

}