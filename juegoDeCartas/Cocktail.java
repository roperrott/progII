package TPE.juegoDeCartas;

import java.util.ArrayList;

public class Cocktail extends PotionElement{
    private ArrayList<PotionElement> potions;

    public Cocktail(String name) {
        super(name);
        potions = new ArrayList<>();
    }

    public void addPotion (PotionElement potion){
        if(!potions.contains(potion)){
            potions.add(potion);
        }
    }

}
