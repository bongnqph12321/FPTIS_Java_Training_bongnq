package com.fis.training.service;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Person;

import java.util.List;

public interface PersonService {
    Person findById(Long id);
    Person createPerson(Person person);
    Person updatePerson(Person person);
    void deletePersonById(Long personId);
    List<Person> findAll();
}
