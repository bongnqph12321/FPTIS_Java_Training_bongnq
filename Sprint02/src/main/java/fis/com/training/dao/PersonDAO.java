package fis.com.training.dao;


import fis.com.training.core.object.Person;

import java.util.List;

public interface PersonDAO extends IDao<Person>{

    Person getPersonById(long personId);
}
