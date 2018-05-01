package com.google.gwt.sample.stockwatcher.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DelistedException extends Exception implements Serializable {

	private String symbol;

	public DelistedException() {
	}

	public DelistedException(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

}
