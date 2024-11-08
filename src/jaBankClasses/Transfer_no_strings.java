package jaBankClasses;

public class Transfer_no_strings {

	private Product from;
	private Product to;
	private double amount;
	private String state;
	
	public Transfer_no_strings(Product from, Product to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.state  = "Pending";
	};
	
	private boolean hasSufficientFunds() {
		boolean result = false;
		if(amount > from.getBalance()) {
			result = true;
		}
		return result;
	}
	
	private void Execute(String operation) {
		String state = "";
		
		if(this.hasSufficientFunds()) {
			this.from.modifyBalance(this.amount, "substract");
			this.to.modifyBalance(this.amount, "add");
		}
		
		state = "Done";		
		this.SetState(state);
		
	}
	
	private void SetState(String state) {
		this.state = state;
	}
	
	private String GetState() {
		return this.state;
	}

	public Product getFrom() {
		return from;
	}

	public void setFrom(Product from) {
		this.from = from;
	}

	public Product getTo() {
		return to;
	}

	public void setTo(Product to) {
		this.to = to;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
}
