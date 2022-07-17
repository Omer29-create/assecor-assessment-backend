package com.versuch.aufgabe.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.versuch.aufgabe.repository.AccountRepository;
import com.versuch.aufgabe.entity.AccountDetails;
import com.versuch.aufgabe.service.BankService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/accounts")
public class BankController {

    @Autowired
    BankService service;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        List<AccountDetails> accountList = new ArrayList<AccountDetails>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(settings);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            AccountDetails account = new AccountDetails();
//            account.setId(Integer.parseInt(record.getString("id")));
            account.setFirstName(record.getString(0));
            account.setLastName(record.getString(1));
            account.setAddress(record.getString(2));
            account.setColor(record.getString(3));
            accountList.add(account);
        });
        service.saveAll(accountList);
        return "Upload Successfull !!!";
    }

    @GetMapping("/all")
    public List<AccountDetails> allAccounts(){
        return  service.findAll();
    }
}

