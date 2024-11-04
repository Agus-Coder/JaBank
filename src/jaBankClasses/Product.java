package jaBankClasses;
import java.util.ArrayList;

public class Product {
	
	private int accountNumber;
	private double accountBalance;
	private ArrayList<Transfer> accountTransfers;
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.accountBalance;
	}
	
	public void modifyBalance(double amount, String operation) {
		if(operation == "substract") {
			this.accountBalance -= amount;
		}
		if(operation == "add") {
			this.accountBalance += amount;	
		}
	}
	
	public void addTransfer(Transfer transfer) {
		this.accountTransfers.add(transfer);
	}
}
