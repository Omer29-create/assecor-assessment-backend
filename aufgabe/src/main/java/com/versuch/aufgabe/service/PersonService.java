package com.versuch.aufgabe.service;

import com.versuch.aufgabe.entity.Person;
import com.versuch.aufgabe.repository.PersonRepository;
import com.versuch.aufgabe.util.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public void saveAll(List<Person> accountList) {
        repository.saveAll(accountList);
    }

    public Person save(Person person){
        return repository.save(person);
    }

    public Person findById(int id) {
        Optional<Person> result = repository.findById(id);
        Person person = null;
        if (result.isPresent()) person = result.get();
        return person;
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public List<Person> findByColorId(int colorCode) {
        List<Person> result = repository.findAllByColor(Color.getColor(String.valueOf(colorCode)));
        return result;
    }

    public List<Person> findByColorName(String color) {
        List<Person> result = repository.findAllByColor(color);
        return result;
    }
}
