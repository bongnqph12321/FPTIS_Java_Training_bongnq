package com.fis.training.service.impl;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Person;
import com.fis.training.repository.PersonRepository;
import com.fis.training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(Long personId) {
        Person person  = personRepository.getById(personId);
        personRepository.deleteById(personId);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
