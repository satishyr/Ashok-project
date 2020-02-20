package com.sai.dao;

import org.springframework.data.repository.CrudRepository;
import com.sai.entities.Accounts;


public interface AccountsRepository extends CrudRepository<Accounts,Integer>{

}
