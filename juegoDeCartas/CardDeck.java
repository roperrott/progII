package juegoDeCartas;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private String name;
	private ArrayList<Card> cards;
	
	
	public CardDeck(String name) {
		super();
		this.name = name;
		cards = new ArrayList<Card>();
	}


	public void importCardDeck (String jsonFile) {
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
            	
            	Card c = new Card(carta.getString("nombre"));
            	
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo : atributos.keySet()) {
                	
                	Attribute atr = new Attribute(nombreAtributo, atributos.getInt(nombreAtributo));
                	c.addAtribut(atr);
                }
                
                this.addCard(c);
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDeckSize(){
		return cards.size();
	}

	//verifico si el mazo es par
	public boolean isPair() {
		return((cards.size() % 2) == 0);
	}
	
	//avarajamos las cartas
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}


	public void addCard(Card c1) {
		if(cards.size()== 0) { //si el arreglo esta vacio, suma la carta sin verificar
			cards.add(c1);
		}else {
			Card firstCard = cards.get(0); // una vez que el mazo tiene cartas agarra la primera
			if(firstCard.verifyCard(c1)) { //y compara todas en funcion de esa
				cards.add(c1);
			}
		}
	}
	
	public Card pickFirstCard() {
		int i = 0;
		return cards.remove(i);
	}
	
	public Card getFirstCard() {
		int i = 0;
		return cards.get(i);
	}

	public String toString() {
		return "CardDeck: "+cards;
	}



}
