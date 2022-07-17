package com.versuch.aufgabe.repository;

import com.versuch.aufgabe.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Integer> {

}
