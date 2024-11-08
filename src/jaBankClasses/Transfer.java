package jaBankClasses;

public class Transfer {

	private String id;
	private String from;
	private String to;
	private String amount;
	private String state;
	
	public Transfer(String id, String from, String to, String amount, String state) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.state  = "Pending";
	};
	
	private boolean hasSufficientFunds() {
		boolean result = false;
		if(amount != "0") {
			result = true;
		}
		return result;
	}
	
	private void execute(String operation) {
		String state = "";
		
		if(this.hasSufficientFunds()) {
			//this.from.modifyBalance(this.amount, "substract");
			//this.to.modifyBalance(this.amount, "add");
		}
		
		state = "Done";		
		this.setState(state);
		
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
