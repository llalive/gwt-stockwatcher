package com.google.gwt.sample.stockwatcher.server;

import java.util.Random;

import com.google.gwt.sample.stockwatcher.client.DelistedException;
import com.google.gwt.sample.stockwatcher.client.StockPrice;
import com.google.gwt.sample.stockwatcher.client.StockPriceService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class StockPriceServiceImpl extends RemoteServiceServlet implements StockPriceService {

	private final double MAX_PRICE = 100.0; // $100.00
	private final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

	@Override
	public StockPrice[] getPrices(String[] stocks) throws DelistedException {
		Random rnd = new Random();
		StockPrice[] prices = new StockPrice[stocks.length];
		for (int i = 0; i < stocks.length; i++) {
			if (stocks[i].equals("ERR")) {
				throw new DelistedException("ERR");
			}

			double price = rnd.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE * (rnd.nextDouble() * 2f - 1f);

			prices[i] = new StockPrice(stocks[i], price, change);
		}
		return prices;
	}

}
