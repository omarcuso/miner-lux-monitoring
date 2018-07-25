package com.minermonitor.model;

public class LuxCore {
	private double	totalSent;
	private double	totalReceived;
	private double	balance;
	
	
	public LuxCore(double totalSent, double totalReceived, double balance) {
		super();
		this.totalSent = totalSent;
		this.totalReceived = totalReceived;
		this.balance = balance;
	}
	
	public LuxCore() {
		super();
	}

	public double getTotalSent() {
		return totalSent;
	}
	public void setTotalSent(double totalSent) {
		this.totalSent = totalSent;
	}
	public double getTotalReceived() {
		return totalReceived;
	}
	public void setTotalReceived(double totalReceived) {
		this.totalReceived = totalReceived;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
