package juegoDeCartas;

public abstract class Potion extends PotionElement{
	
	private String atrModifName;
	
    public Potion(String name, String atrModif) {
        super(name);
        this.atrModifName = atrModif;
    }

    public String getAtrModifName() {
    	return this.atrModifName;
    }

    //Es abstracta porque cada pocion va a aplicar el efecto de forma distinta
    public abstract int applyEffects(String atrName, int atrValue);

    

}
