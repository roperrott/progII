package TPE.juegoDeCartas;

public abstract class PotionElement {
    private String name;
    private Card assignedCard;

    public PotionElement(String name) {
        this.name = name;
        assignedCard = null;
    }

    public String getName() {
        return name;
    }

    //lo asigno a una carta
    public void assignedToCard(Card c){
        this.assignedCard = c;
    }


}
