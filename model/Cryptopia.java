package com.minermonitor.model;

public class Cryptopia {
private String label;
private double askPrice;
private double bidPrice;
private double low;
private double higth;
private double volume;
private double lastPrice;
private double buyVolume;
private double sellVolume;
private double change;
private double open;
private double close;
private double baseVolume;
private double buyBaseVolume;
private double sellBaseVolume;

public Cryptopia(String label, double askPrice, double bidPrice, double low, double higth, double volume,
		double lastPrice, double buyVolume, double sellVolume, double change, double open, double close,
		double baseVolume, double buyBaseVolume, double sellBaseVolume) {
	super();
	this.label = label;
	this.askPrice = askPrice;
	this.bidPrice = bidPrice;
	this.low = low;
	this.higth = higth;
	this.volume = volume;
	this.lastPrice = lastPrice;
	this.buyVolume = buyVolume;
	this.sellVolume = sellVolume;
	this.change = change;
	this.open = open;
	this.close = close;
	this.baseVolume = baseVolume;
	this.buyBaseVolume = buyBaseVolume;
	this.sellBaseVolume = sellBaseVolume;
}

public Cryptopia() {
	super();
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public double getAskPrice() {
	return askPrice;
}

public void setAskPrice(double askPrice) {
	this.askPrice = askPrice;
}

public double getBidPrice() {
	return bidPrice;
}

public void setBidPrice(double bidPrice) {
	this.bidPrice = bidPrice;
}

public double getLow() {
	return low;
}

public void setLow(double low) {
	this.low = low;
}

public double getHigth() {
	return higth;
}

public void setHigth(double higth) {
	this.higth = higth;
}

public double getVolume() {
	return volume;
}

public void setVolume(double volume) {
	this.volume = volume;
}

public double getLastPrice() {
	return lastPrice;
}

public void setLastPrice(double lastPrice) {
	this.lastPrice = lastPrice;
}

public double getBuyVolume() {
	return buyVolume;
}

public void setBuyVolume(double buyVolume) {
	this.buyVolume = buyVolume;
}

public double getSellVolume() {
	return sellVolume;
}

public void setSellVolume(double sellVolume) {
	this.sellVolume = sellVolume;
}

public double getChange() {
	return change;
}

public void setChange(double change) {
	this.change = change;
}

public double getOpen() {
	return open;
}

public void setOpen(double open) {
	this.open = open;
}

public double getClose() {
	return close;
}

public void setClose(double close) {
	this.close = close;
}

public double getBaseVolume() {
	return baseVolume;
}

public void setBaseVolume(double baseVolume) {
	this.baseVolume = baseVolume;
}

public double getBuyBaseVolume() {
	return buyBaseVolume;
}

public void setBuyBaseVolume(double buyBaseVolume) {
	this.buyBaseVolume = buyBaseVolume;
}

public double getSellBaseVolume() {
	return sellBaseVolume;
}

public void setSellBaseVolume(double sellBaseVolume) {
	this.sellBaseVolume = sellBaseVolume;
}


}
