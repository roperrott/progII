package TPE.juegoDeCartas;

public class StubbornStrategy implements Strategy{
    private String atribut;

    public StubbornStrategy(String atribut) {
        this.atribut = atribut;
    }

    public void setAtribut(String atribut) {
        this.atribut = atribut;
    }

    @Override
    public String selectAttribute(Card c) {
        return c.getFavoriteAttribute(atribut);
    }
}
