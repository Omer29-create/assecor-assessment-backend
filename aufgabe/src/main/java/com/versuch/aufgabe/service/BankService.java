package com.versuch.aufgabe.service;

import com.versuch.aufgabe.entity.AccountDetails;
import com.versuch.aufgabe.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    AccountRepository repository;

    public List<AccountDetails> findAll(){
        return repository.findAll();
    }

    public void saveAll(List<AccountDetails> accountList) {
        repository.saveAll(accountList);
    }


}
