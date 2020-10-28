package TPE.juegoDeCartas;

import java.util.ArrayList;

public class Game {
	
	private Player player1;
	private Player player2;
	private CardDeck cards;
	private int maxRounds;
	private Player roundWinner;
	private String historyLog;
	private ArrayList<PotionElement> potions;

	
	
	public Game(Player player1, Player player2, CardDeck cards, int maxRounds, Player roundWinner) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.cards = cards;
		this.maxRounds = maxRounds;
		this.roundWinner = roundWinner;
		historyLog = " ";
		potions = new ArrayList<>();
	}

	//agregar pociones al juego
	public void addPotionToGame(PotionElement potion){
		if(!potions.contains(potion)){
			potions.add(potion);
		}
	}

	public boolean hasPotions(){
		return potions.size() != 0;
	}
	
	public String getHistoryLog() {
		return historyLog;
	}

	//sumo un registro al historial de movimientos del juego
	public void addHistoryLog(String log) {
		this.historyLog += log;
	}

	public Player getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(Player roundWinner) {
		this.roundWinner = roundWinner;
	}

	public Player getPlayer1() {
		return player1;
	}


	public Player getPlayer2() {
		return player2;
	}


	public CardDeck getCards() {
		return cards;
	}


	public int getMaxRounds() {
		return maxRounds;
	}


	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

	private void spreadCard(Player p){
		Card c = cards.getFirstCard();
		this.dividePotions(c);
		p.addCard(c);
		p.shuffleMyCards();
	}

	private void dividePotions(Card c){
		if(this.hasPotions()){
			c.setPotion(potions.remove(0));
		}
	}

	private void divideCards() {
		cards.shuffleDeck(); //avarajamos las cartas antes de repartir
		int total = cards.getDeckSize();

		for (int i=1; i<=total; i++) {
			if(cards.isPair()) {
				this.spreadCard(player2);
			}else {
				this.spreadCard(player1);
			}
		}
	}
	
	private void setFirstHand() {
		if (player1.pickNumber() > player2.pickNumber()) {
			this.setRoundWinner(player1);
		}else {
			this.setRoundWinner(player2);
		}
	}
	
	private void play() {
		int playedRounds = 0;

		while ((playedRounds < maxRounds) && 
				(player1.getAmountOfCards() > 0) &&
					(player2.getAmountOfCards() > 0)) {
			
			playedRounds++;
			this.addHistoryLog("------- Ronda " + playedRounds + " -------\n\n");
			
			startRound();
			
		}
		
		if(player1.getAmountOfCards() > player2.getAmountOfCards()) {
			this.addHistoryLog("\n" + player1 + " Gana el Juego!!!");
		} else {
			this.addHistoryLog("\n" + player2 + " Gana el Juego!!!");
		}
		
	}
	
	public void startGame() {
		divideCards();
		setFirstHand();
		play();
	}
	
	
	public void startRound() {

		String playedAttribute = roundWinner.pickAttribute(roundWinner.getFirstCard()); //random responsabilidad del jugador
		
		Card card1 = player1.pickFirstCard();
		Card card2 = player2.pickFirstCard();

		Attribute atr1 = card1.getAtrByName(playedAttribute);
		Attribute atr2 = card2.getAtrByName(playedAttribute);
		
		this.addHistoryLog("El Jugador " + roundWinner + " selecciona competir por el atributo "+playedAttribute+"\n");
		this.addHistoryLog("La Carta de " + player1 + " es " + card1 + " con " + atr1 + "\n");
		this.addHistoryLog("La Carta de " + player2 + " es " + card2 + " con " + atr2 + "\n");
		
		int comparison = atr1.compareTo(atr2);
		
		if (comparison > 0) {
			this.setWinner(player1 , card1, card2);
		}
		else if (comparison < 0) {
			this.setWinner(player2 , card1, card2);
		}
		else {
			player1.addCard(card1);
			player2.addCard(card2);
		}

		this.addHistoryLog("Gana la ronda " + roundWinner + "\n");
		this.addHistoryLog(player1 + " posee ahora " + player1.getAmountOfCards() + " cartas y "+
				player2+" posee ahora " + player2.getAmountOfCards() + " cartas\n\n");
	
	}
	
	private void setWinner(Player player, Card card1, Card card2) {
		player.addCard(card2);
		player.addCard(card1);
		this.setRoundWinner(player);
	}
	
	
}
