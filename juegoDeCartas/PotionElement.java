package juegoDeCartas;

public abstract class PotionElement {
    private String name;


    public PotionElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract int applyEffects(String atrName, int atrValue);


}
