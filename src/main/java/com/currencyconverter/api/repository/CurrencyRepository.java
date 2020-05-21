package com.currencyconverter.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.currencyconverter.api.entity.Currency;
import com.currencyconverter.api.entity.CurrencyCode;

@Repository
public interface CurrencyRepository extends MongoRepository<CurrencyCode, String>{
	
	Currency findByCode(String code);
	
	List<CurrencyCode> findByOrderByCodeAsc();

}
