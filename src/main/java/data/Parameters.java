package data;

public class Parameters {
    private int cardsNumber;
    private Card[] cards;

    public int getCardsNumber() {
        return cardsNumber;
    }

    public Parameters(int cardsNumber, Card[] cards) {
        this.cardsNumber = cardsNumber;
        this.cards = cards;
    }

    public Card[] getCardsValues() {
        return cards;
    }
}
