package com.fis.training.controller;

import com.fis.training.model.CriminalCase;
import com.fis.training.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/criminal")
@CrossOrigin("*")
public class CriminalRestController {
    @Autowired
    CriminalCaseService criminalCaseService;

    @PostMapping
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase){
        CriminalCase criminalCase1 = this.criminalCaseService.createCriminalCase(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @GetMapping
    public List<CriminalCase> getAllCriminalCase(){
        return criminalCaseService.findAll();
    }

    @PutMapping
    public CriminalCase updateCriminalCase(@RequestBody CriminalCase criminalCase){
        return this.criminalCaseService.updateCriminalCase(criminalCase);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCriminalCase(@PathVariable Long id) {
        this.criminalCaseService.deleteCriminalCaseById(id);
    }

    @GetMapping("{id}")
    public CriminalCase getById(@PathVariable Long id){
        return  this.criminalCaseService.findById(id);
    }

}
