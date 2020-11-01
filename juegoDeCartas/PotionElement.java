package juegoDeCartas;

public abstract class PotionElement {
    private String name;


    protected PotionElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract int applyEffects(String atrName, int atrValue);

    @Override
    public boolean equals(Object o) {
    	try {
    		PotionElement aux = (PotionElement) o;
    		return aux.getName().equals(this.getName());
    	} catch (Exception e) {
    		return false;
    	}
    	
    }

}
