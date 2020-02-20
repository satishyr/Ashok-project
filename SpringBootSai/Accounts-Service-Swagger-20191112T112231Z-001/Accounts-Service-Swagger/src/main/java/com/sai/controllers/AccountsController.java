package com.sai.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.dao.AccountsRepository;
import com.sai.entities.Accounts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="/accounts",description="Manage accounts")
public class AccountsController {

	@Autowired
	private AccountsRepository accountsRepository;
	
	@GetMapping(value="/account")
	@ApiOperation(value="Return accounts information")
	@ApiResponses(value= {@ApiResponse(code=200,message="account details fetched")})
	public Iterable<Accounts> findAll(){
		System.out.println("In find all"+accountsRepository.count());
		return accountsRepository.findAll();
	}
	@PostMapping(value="/save")
	@ApiOperation(value="update accounts information")
	@ApiResponses(value= {@ApiResponse(code=200,message="Account details saved")})
	public Accounts save(@RequestBody Accounts accounts) {
		return accountsRepository.save(accounts);
	}
	
}
