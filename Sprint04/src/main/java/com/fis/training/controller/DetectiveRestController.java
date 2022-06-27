package com.fis.training.controller;

import com.fis.training.model.Detective;
import com.fis.training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detective")
@CrossOrigin("*")
public class DetectiveRestController {
    @Autowired
    DetectiveService detectiveService;

    @PostMapping
    public ResponseEntity<Detective> addDetective(@RequestBody Detective detective){
        Detective detective1 = this.detectiveService.createDetective(detective);
        return ResponseEntity.ok(detective1);
    }

    @GetMapping("/getAll")
    public List<Detective> getAllCriminalCase(){
        return detectiveService.findAll();
    }

    @PutMapping
    public Detective updateDetective(@RequestBody Detective detective){
        return this.detectiveService.updateDetective(detective);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetective(@PathVariable Long id) {
        this.detectiveService.deleteDetectiveById(id);
    }

    @GetMapping("{id}")
    public Detective getById(@PathVariable Long id){
        return  this.detectiveService.findById(id);
    }
}
