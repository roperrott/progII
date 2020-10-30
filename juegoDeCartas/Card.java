package TPE.juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
	private String name;
	private ArrayList<Attribute> attributes;
	private PotionElement potion;

	
	public Card(String name) {
		super();
		this.name = name;
		attributes = new ArrayList<Attribute>();
		potion = null;
	}

	//le agrego una pocion a la carta al repartir
	public void setPotion(PotionElement potion){
		this.potion = potion;
	}

	//verifico si la carta tiene una pocion
	public boolean hasPotion(){
		return (potion != null);
	}
	
	public void addAtribut(Attribute at) {
		attributes.add(at);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//REVEER NO SE SI ES NECESARIO!!
	public ArrayList<Attribute> getAttributes(){
		return new ArrayList<Attribute>(attributes);
	}
	
	//calcula una posicion del arreglo de atributos al azar
	//hago un casting a int porque sino devuelve un double
	//obtengo el nombre del atributo que quiero agarrar
	public String getRandomAtr() {
		int i = 0;
		String aux = "";
		int attributesQ = attributes.size();
		
			i = (int) Math.floor((Math.random()*attributesQ));
			aux = attributes.get(i).getName();
			
		return aux;
	}

	public String pickHigherAtribut(){
		ArrayList<Attribute> aux = new ArrayList<>(attributes);
		Collections.sort(aux);
		Collections.reverse(aux);
		return aux.get(0).getName();
	}

	
	public boolean containsAtribut(Attribute atr) {
		return attributes.contains(atr);
	}
	
	//Agarro el atributo de la carta por medio
	//del nombre del atributo que eligio el jugador que inicio la ronda
	
	public Attribute getAtrByName(String name ) {
		
		for(int i=0; i<attributes.size(); i++) {
			Attribute aux = attributes.get(i);
			if(aux.getName().equals(name))
				return aux;
		}
		return null;
	}
	
	
	public boolean verifyCard(Card card) {
			
			if(this.getAtributsQuantity() == card.getAtributsQuantity()) {
				
				for (int i = 0 ; i< this.attributes.size();i++) {
					Attribute attribute = this.attributes.get(i);
					
					if(!card.containsAtribut(attribute)) {
						return false;
					}
				}
				return true;
			}
			
			return false;
		}
	
	public int getAtributsQuantity() {
		return attributes.size();
	}
	
	
	@Override
	public String toString() {
		return name;
	}

}
