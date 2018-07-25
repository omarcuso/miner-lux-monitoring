package com.minermonitor.model;

public class Spread {
	private double volume;
	private long total;
	private double highbid;
	
	public Spread(double volume, long total, double highbid) {
		super();
		this.volume = volume;
		this.total = total;
		this.highbid = highbid;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public double getHighbid() {
		return highbid;
	}
	public void setHighbid(double highbid) {
		this.highbid = highbid;
	}
}
