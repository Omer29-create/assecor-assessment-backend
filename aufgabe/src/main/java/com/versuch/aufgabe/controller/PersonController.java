package com.versuch.aufgabe.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.versuch.aufgabe.entity.Person;
import com.versuch.aufgabe.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        List<Person> personList = new ArrayList<Person>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(settings);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            Person account = new Person();
            account.setFirstName(record.getString(0));
            account.setLastName(record.getString(1));
            account.setZipcode(record.getString(2).substring(0,5));
            account.setCity(record.getString(2).substring(6));
            account.setColor(record.getString(3));
            personList.add(account);
        });
        service.saveAll(personList);
        return "Upload Successfull !!!";
    }

    @GetMapping("/persons")
    public List<Person> allPersons(){
        return  service.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person findById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/persons/color/{color}")
    public List<Person> findByColorId(@PathVariable int color){
        return service.findByColorId(color);
    }

    @GetMapping("/persons/color/name/{color}")
    public List<Person> findByColorName(@PathVariable String color){
        return service.findByColorName(color);
    }

    @PostMapping("persons/add")
    public Person addPerson(@RequestBody Person person){
        return service.save(person);
    }
}
