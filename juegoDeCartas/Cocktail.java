package juegoDeCartas;

import java.util.ArrayList;

public class Cocktail extends PotionElement{
    private ArrayList<PotionElement> potions;

    public Cocktail(String name) {
        super(name);
        potions = new ArrayList<>();
    }

    @Override
    public int applyEffects(String atrName, int atrValue) {
        for(PotionElement elem: potions){
            atrValue = elem.applyEffects(atrName, atrValue);
        }
        return atrValue;
    }

    public void addPotion (PotionElement potion){
        if(!potions.contains(potion)){
            potions.add(potion);
        }
    }

}
