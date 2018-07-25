package com.minermonitor.model;

public class Pickaxe {
	private String coin;
	private double unsold;
	private double balance;
	private double unpaid;
	private double paid24h;
	private double total;
	
	
	public Pickaxe(String coin, double unsold, double balance, double unpaid, double paid24h, double total) {
		super();
		this.coin = coin;
		this.unsold = unsold;
		this.balance = balance;
		this.unpaid = unpaid;
		this.paid24h = paid24h;
		this.total = total;
	}
	public Pickaxe() {
		
	}
	public String getCoin() {
		return coin;
	}
	public void setCoin(String coin) {
		this.coin = coin;
	}
	public double getUnsold() {
		return unsold;
	}
	public void setUnsold(double unsold) {
		this.unsold = unsold;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getUnpaid() {
		return unpaid;
	}
	public void setUnpaid(double unpaid) {
		this.unpaid = unpaid;
	}
	public double getPaid24h() {
		return paid24h;
	}
	public void setPaid24h(double paid24h) {
		this.paid24h = paid24h;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
