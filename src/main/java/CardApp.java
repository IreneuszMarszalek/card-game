import data.Card;

public class CardApp {
    public static void main(String[] args) {
        Card card1 = new Card("Pik", "A");
        System.out.println(card1.getColor());
        System.out.println(card1.getValue());
        System.out.println(card1.getColorSeniority());
        System.out.println(card1.getValueSeniority());
        card1.displayCard();

        Card card2 = new Card("Kier", "J");
        System.out.println(card2.getColor());
        System.out.println(card2.getValue());
        System.out.println(card2.getColorSeniority());
        System.out.println(card2.getValueSeniority());
        card2.displayCard();
    }
}
