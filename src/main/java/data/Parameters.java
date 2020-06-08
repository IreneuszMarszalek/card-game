package data;

public class Parameters {
    private int cardsNumber;
    private String[] cardsValues;

    public int getCardsNumber() {
        return cardsNumber;
    }

    public Parameters(int cardsNumber, String[] cardsValues) {
        this.cardsNumber = cardsNumber;
        this.cardsValues = cardsValues;
    }

    public String[] getCardsValues() {
        return cardsValues;
    }
}
