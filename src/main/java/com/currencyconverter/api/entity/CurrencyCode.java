package com.currencyconverter.api.entity;

import java.util.List;

public class CurrencyCode {

	private List<Currency> code;

	private String codeValue;

	public List<Currency> getCode() {
		return code;
	}

	public void setCode(List<Currency> code) {
		this.code = code;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

}
