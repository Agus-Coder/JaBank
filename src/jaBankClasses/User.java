package jaBankClasses;
import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private int socialNumber;
	private ArrayList<Product> products;
	private ArrayList<Card> cards;

	public User() {
		
	}

	public User(String firstName, String lastName, int socialNumber, ArrayList<Product> products,
			ArrayList<Card> cards) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialNumber = socialNumber;
		this.products = products;
		this.cards = cards;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSocialNumber() {
		return socialNumber;
	}

	public void setSocialNumber(int socialNumber) {
		this.socialNumber = socialNumber;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card newCard) {
		this.cards.add(newCard);
	}
	
	
	
}
