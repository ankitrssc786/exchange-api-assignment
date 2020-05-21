package com.currencyconverter.api.entity;

import java.math.BigDecimal;

public class Currency {

	private BigDecimal bid;

	private BigDecimal market;

	private BigDecimal ask;

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getMarket() {
		return market;
	}

	public void setMarket(BigDecimal market) {
		this.market = market;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

}
