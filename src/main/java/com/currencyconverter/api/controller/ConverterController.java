package com.currencyconverter.api.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.currencyconverter.api.entity.CustomExchangeRate;
import com.currencyconverter.api.entity.User;
import com.currencyconverter.api.service.CustomExchangeRateService;
import com.currencyconverter.api.service.UserService;

@RestController
public class ConverterController {

	@Inject
	private CustomExchangeRateService converterService;
	
	@Inject
	private UserService userService;

	// Get User Details
	@GetMapping
	@RequestMapping("/user/profile/userId")
	public User getUserDetails(@RequestParam(name = "userId", required = true) int userId) {
		return this.userService.findById(userId);
	}

	//
	@GetMapping
	@RequestMapping("/rates/latest")
	public List<CustomExchangeRate> refreshRates(
			@RequestParam(name = "baseCurrencyCode", required = true) String baseCurrencyCode)
			throws Exception {
		return this.converterService.refreshRates(baseCurrencyCode);
	}

}
