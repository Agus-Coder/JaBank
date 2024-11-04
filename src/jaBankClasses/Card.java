package jaBankClasses;

import java.util.Date;

public class Card {
	private int number;
	private Date expiry;
	private double availableBalance;
	private double balanceDue;
	private String type;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Date getExpiry() {
		return expiry;
	}
	
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	
	public double getAvailableBalance() {
		return availableBalance;
	}
	
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public double getBalanceDue() {
		return balanceDue;
	}
	
	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
