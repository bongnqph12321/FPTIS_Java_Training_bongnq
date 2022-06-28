package com.fis.training.controller;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.model.core.Rank;
import com.fis.training.service.CriminalCaseService;
import com.fis.training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/criminal")
@CrossOrigin("*")
public class CriminalRestController {
    @Autowired
    CriminalCaseService criminalCaseService;
    @Autowired
    DetectiveService detectiveService;

    @PostMapping
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase) {
        CriminalCase criminalCase1 = this.criminalCaseService.createCriminalCase(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @GetMapping
    public List<CriminalCase> getAllCriminalCase() {
        return criminalCaseService.findAll();
    }

    @PutMapping
    public CriminalCase updateCriminalCase(@RequestBody CriminalCase criminalCase) {
        return this.criminalCaseService.updateCriminalCase(criminalCase);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCriminalCase(@PathVariable Long id) {
        this.criminalCaseService.deleteCriminalCaseById(id);
    }

    @GetMapping("{id}")
    public CriminalCase getById(@PathVariable Long id) {
        return this.criminalCaseService.findById(id);
    }

    @GetMapping("/findByRank/{rank}")
    public List<CriminalCase> getByRank(@PathVariable Rank rank) {
        Detective detective = detectiveService.findByRank(rank);
        System.out.println(detective);
        List<CriminalCase> list = criminalCaseService.findAll();
        List<CriminalCase> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLeadInvestigator().equals(detective)) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }
}
