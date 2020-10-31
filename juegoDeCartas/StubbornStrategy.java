package juegoDeCartas;

public class StubbornStrategy implements Strategy{
    private String attribute;

    public StubbornStrategy(String attribute) {
        this.attribute = attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String selectAttribute(Card c) {
         return attribute;
    }
}
