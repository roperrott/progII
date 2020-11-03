package strategies;

import juegoDeCartas.Card;

public class AmbitiousStrategy implements Strategy{

    public AmbitiousStrategy() {
    }

    @Override
    public String selectAttribute(Card c) {
       return c.pickHigherAtribut();
    }

}
