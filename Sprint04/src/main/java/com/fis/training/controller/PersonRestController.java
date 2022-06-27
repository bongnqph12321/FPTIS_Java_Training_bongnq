package com.fis.training.controller;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Person;
import com.fis.training.service.CriminalCaseService;
import com.fis.training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
@CrossOrigin("*")
public class PersonRestController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> addCriminalCase(@RequestBody Person person){
        Person person1 = personService.createPerson(person);
        return ResponseEntity.ok(person1);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.findAll();
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person Person){
        return this.personService.updatePerson(Person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        this.personService.deletePersonById(id);
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable Long id){
        return  this.personService.findById(id);
    }
}
