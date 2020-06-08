import Application.ParametersProvider;
import data.Card;
import data.Parameters;
import logic.Utils;

import java.util.Arrays;

public class CardApp {
    public static void main(String[] args) {
        Utils utils = new Utils();

        Card card1 = new Card("Pik", "A");
        System.out.println(card1.getColor());
        System.out.println(card1.getValue());
        System.out.println(utils.getColorSeniority(card1));
        System.out.println(utils.getValueSeniority(card1));
        utils.displayCard(card1);

        Card card2 = new Card("Kier", "J");
        System.out.println(card2.getColor());
        System.out.println(card2.getValue());
        System.out.println(utils.getColorSeniority(card2));
        System.out.println(utils.getValueSeniority(card2));
        utils.displayCard(card2);

        ParametersProvider paramProvider = new ParametersProvider();

        Parameters param = paramProvider.fetchParameters();

        System.out.println(param.getCardsNumber());
        System.out.println(Arrays.toString(param.getCardsValues()));
    }
}
