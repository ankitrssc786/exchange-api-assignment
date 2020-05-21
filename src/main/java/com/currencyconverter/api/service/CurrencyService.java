package com.currencyconverter.api.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.api.entity.CurrencyCode;
import com.currencyconverter.api.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Inject
	private CurrencyRepository currencyRepository;
	
	public List<CurrencyCode> findAllCurrencies() {
		return this.currencyRepository.findByOrderByCodeAsc();
	}

}
