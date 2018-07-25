package com.minermonitor.model;

public class Bx {
	private double volume24hours;
	private double change;
	private String primaryCurrency;
	private String secondaryCurrency;
	private double lastPrice;
	private Spread asks;
	private Spread bids;
	
	public Bx(double volume24hours, double change, String primaryCurrency, String secondaryCurrency, double lastPrice,
			Spread asks, Spread bids) {
		super();
		this.volume24hours = volume24hours;
		this.change = change;
		this.primaryCurrency = primaryCurrency;
		this.secondaryCurrency = secondaryCurrency;
		this.lastPrice = lastPrice;
		this.asks = asks;
		this.bids = bids;
	}
	
	public Bx() {
		
	}
	public double getVolume24hours() {
		return volume24hours;
	}
	public void setVolume24hours(double volume24hours) {
		this.volume24hours = volume24hours;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public String getPrimaryCurrency() {
		return primaryCurrency;
	}
	public void setPrimaryCurrency(String primaryCurrency) {
		this.primaryCurrency = primaryCurrency;
	}
	public String getSecondaryCurrency() {
		return secondaryCurrency;
	}
	public void setSecondaryCurrency(String secondaryCurrency) {
		this.secondaryCurrency = secondaryCurrency;
	}
	public double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public Spread getAsks() {
		return asks;
	}
	public void setAsks(Spread asks) {
		this.asks = asks;
	}
	public Spread getBids() {
		return bids;
	}
	public void setBids(Spread bids) {
		this.bids = bids;
	}
	
	
}
