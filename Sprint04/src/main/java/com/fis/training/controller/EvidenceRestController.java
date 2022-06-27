package com.fis.training.controller;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.model.Evidence;
import com.fis.training.service.DetectiveService;
import com.fis.training.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/evidence")
@CrossOrigin("*")
public class EvidenceRestController {
    @Autowired
    EvidenceService evidenceService;

    @PostMapping
    public ResponseEntity<Evidence> addEvidence(@RequestBody Evidence evidence){
        Evidence evidence1 = this.evidenceService.createEvidence(evidence);
        return ResponseEntity.ok(evidence1);
    }

    @GetMapping
    public List<Evidence> getAllCriminalCase(){
        return evidenceService.findAll();
    }

    @PutMapping
    public Evidence updateEvidence(@RequestBody Evidence evidence){
        return this.evidenceService.updateEvidence(evidence);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvidence(@PathVariable Long id) {
        this.evidenceService.deleteEvidenceById(id);
    }

    @GetMapping("{id}")
    public Evidence getById(@PathVariable Long id){
        return  this.evidenceService.findById(id);
    }
}
