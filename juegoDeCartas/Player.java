package juegoDeCartas;

import strategies.Strategy;

public class Player{
	private String name;
	private CardDeck myCards;
	private Strategy strategy;

	public Player(String name, Strategy strategy) {
		super();
		this.name = name;
		myCards = new CardDeck("My cards");
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCard(Card c1) {

		myCards.addCard(c1);
	}
	
	
	public Card getFirstCard() {
		return myCards.getFirstCard();
	}
	
	public Card pickFirstCard() {

		return myCards.pickFirstCard();
	}

	public void shuffleMyCards(){
		myCards.shuffleDeck();
	}
	
	
	//devuelve la totalidad de cartas
	public int getAmountOfCards() {

		return myCards.getDeckSize();

	}
	
	//elije un numero al azar para ver quien empieza el juego
	public int pickNumber() {

		int max=10;

		int i = (int) Math.floor((Math.random()*max)+1);
		return i;
		
	}

	@Override
	public String toString() {

		return name;
	}

	public String pickAttribute(Card c){
		return this.strategy.selectAttribute(c);
	}

	
}
