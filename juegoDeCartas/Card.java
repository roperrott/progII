package TPE.juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
	private String name;
	private ArrayList<Attribute> atributs;
	private PotionElement potion;

	
	public Card(String name) {
		super();
		this.name = name;
		atributs = new ArrayList<Attribute>();
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
		atributs.add(at);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Attribute> getAtributs(){
		return new ArrayList<Attribute>(atributs);
	}
	
	//calcula una posicion del arreglo de atributos al azar
	//hago un casting a int porque sino devuelve un double
	//obtengo el nombre del atributo que quiero agarrar
	public String getRandomAtr() {
		int i = 0;
		String aux = "";
		int atributsQ = atributs.size();
		
			i = (int) Math.floor((Math.random()*atributsQ));
			aux = atributs.get(i).getName();
			
		return aux;
	}

	public String pickHigherAtribut(){
		ArrayList<Attribute> aux = new ArrayList<>(atributs);
		Collections.sort(aux);
		Collections.reverse(aux);
		return aux.get(0).getName();
	}

	
	public boolean containsAtribut(Attribute atr) {
		return atributs.contains(atr);
	}
	
	//Agarro el atributo de la carta por medio
	//del nombre del atributo que eligio el jugador que inicio la ronda
	
	public Attribute getAtrByName(String name ) {
		
		for(int i=0; i<atributs.size(); i++) {
			Attribute aux = atributs.get(i);
			if(aux.getName().equals(name))
				return aux;
		}
		return null;
	}

	public String getFavoriteAttribute(String atr){
		for(int i=0; i<atributs.size(); i++) {
			Attribute aux = atributs.get(i);
			if(aux.getName().equals(name))
				return aux.getName();
		}
		return null;
	}
	
	
	public boolean verifyCard(Card card) {
			
			if(this.getAtributsQuantity() == card.getAtributsQuantity()) {
				
				for (int i = 0 ; i< this.atributs.size();i++) {
					Attribute atribut = this.atributs.get(i);
					
					if(!card.containsAtribut(atribut)) {
						return false;
					}
				}
				return true;
			}
			
			return false;
		}
	
	public int getAtributsQuantity() {
		return atributs.size();
	}
	
	
	@Override
	public String toString() {
		return name;
	}

}
