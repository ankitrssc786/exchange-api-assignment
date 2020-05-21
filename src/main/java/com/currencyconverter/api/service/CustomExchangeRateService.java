package com.currencyconverter.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.api.entity.CurrencyCode;
import com.currencyconverter.api.entity.CustomExchangeRate;
import com.currencyconverter.api.repository.CustomExchangeRateRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class CustomExchangeRateService {

	@Inject
	private CurrencyService currencyService;

	@Inject
	private CustomExchangeRateRepository customExchangeRateRepository;

	// Return new exchange rate
	public List<CustomExchangeRate> refreshRates(String baseCurrencyCode) throws Exception {

		List<CurrencyCode> allCurrencies = this.currencyService.findAllCurrencies();

		List<CustomExchangeRate> allExchangeRates = new ArrayList<>();
		List<CurrencyCode> currCodeList = new ArrayList<CurrencyCode>();
		CustomExchangeRate customExchangeRate = new CustomExchangeRate();

		String json = null;
		try {
			json = readUrl("https://api.exchangeratesapi.io/latest?base=" + baseCurrencyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();

		if (!Objects.isNull(json)) {
			int i = 0;
			JsonObject jsonRates = gson.fromJson(json, JsonObject.class);
			for (CurrencyCode currency : allCurrencies) {
				i++;
				JsonElement rateJsonElement = jsonRates.getAsJsonObject("rates").get(currency.getCodeValue());
				if (!Objects.isNull(rateJsonElement)) {
					customExchangeRate = this.customExchangeRateRepository
							.findByBaseCurrencyCodeAndTermCurrencyCode(baseCurrencyCode, currency.getCodeValue());
				}
				customExchangeRate.setRates(currCodeList);
				customExchangeRate.setBaseCurrency(baseCurrencyCode);
			}

			allExchangeRates.add(customExchangeRate);

		}

		return allExchangeRates;
	}

	// Return StringURL
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}
