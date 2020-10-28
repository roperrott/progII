package TPE.juegoDeCartas;

import java.util.ArrayList;

public abstract class Potion extends PotionElement{
    private ArrayList<Attribute> atributs;

    public Potion(String name) {
        super(name);
        atributs = new ArrayList<>();
    }

    public void addAtribut(Attribute atr){
        if(!atributs.contains(atr)){
            atributs.add(atr);
        }
    }

    public int getAmountOfAtributs(){

        return atributs.size();
    }

    //determino si la pocion ya existe
    public boolean equals(Object obj){
        try{
            Potion potion = (Potion) obj;
            return (this.getName().equals(potion.getName()) &&
                    this.getAmountOfAtributs() == potion.getAmountOfAtributs());
        }catch (Exception e){
            return false;
        }
    }


}
