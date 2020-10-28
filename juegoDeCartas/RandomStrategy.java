package TPE.juegoDeCartas;

public class RandomStrategy implements Strategy{

    public RandomStrategy() {
    }

    @Override
    public String selectAttribute(Card c) {
       return c.getRandomAtr();
    }
}
