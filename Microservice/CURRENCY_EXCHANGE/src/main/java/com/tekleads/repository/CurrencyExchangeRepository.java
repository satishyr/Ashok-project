package com.tekleads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekleads.entity.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Integer> {

	@Query("from CurrencyExchangeEntity where currencyFrom=:from and currencyTo=:to")
	public CurrencyExchangeEntity findCurrencyValByFromAndTo(String from, String to);

}
