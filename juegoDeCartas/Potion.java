package juegoDeCartas;

public abstract class Potion extends PotionElement{
    private Attribute attribute;

    public Potion(String name, Attribute attribute) {
        super(name);
        this.attribute = attribute;
    }


    //Es abstracta porque cada pocion va a aplicar el efecto de forma distinta
    public abstract int applyEffects(String atrName, int atrValue);


}
