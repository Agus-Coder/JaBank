package jaBankClasses;

public class Transfer {

	private Product from;
	private Product to;
	private double amount;
	private String state;
	
	public Transfer(Product from, Product to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.state  = "Pending";
	};
	
	private boolean Validate() {
		boolean result = false;
		if(amount > from.getBalance()) {
			result = true;
		}
		return result;
	}
	
	private void Execute(String operation) {
		String state = "";
		try {
			if(this.Validate()) {
				this.from.modifyBalance(this.amount, "substract");
				this.to.modifyBalance(this.amount, "add");
			}
			state = "Done";
		}catch (){
			state = "Error";
		}finally {
			this.SetState(state);
			
		}
		
	}
	
	private void SetState(String state) {
		this.state = state;
	}
	
	private String GetState() {
		return this.state;
	}
	
}
