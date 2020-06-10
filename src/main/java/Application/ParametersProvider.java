package Application;

import data.Card;
import data.Parameters;
import logic.Utils;

import java.util.Scanner;

public class ParametersProvider {
    public Parameters fetchParameters(){
        Scanner scanner = new Scanner(System.in);

        String temp;
        int numberOfCards;
        Card[] cards = new Card[13];
        do{
            System.out.print("Provide the number of cards <1-13>: ");
            temp = scanner.nextLine();
            numberOfCards = validateCardsNumber(temp);
        }while (numberOfCards == -1);

        for (int i = 1; i <= numberOfCards; i++) {
            //TODO: check if cards was already provided
            do{
                System.out.print("Provide card " + i + "/" + numberOfCards + " value <2,3,4,5,6,7,8,9,10,J,Q,K,A>:");
                temp = scanner.nextLine();
                if (!checkIfCardAlreadyChosen(i-1, cards, temp)){
                    System.out.println("Cards value already chosen");
                    System.out.print("Provide card " + i + "/" + numberOfCards + " value <2,3,4,5,6,7,8,9,10,J,Q,K,A>:");
                    continue;
                }
                cards[i-1] = new Card("Pik", validateCardValue(temp));
            }while(cards[i-1].getValue() == null);
        }

        return new Parameters(numberOfCards, cards);
    }

    private int validateCardsNumber (String cardsNumber){
        if (cardsNumber == null){
            return -1;
        }

        if(cardsNumber.length() > 2){
            return -1;
        }

        String[] template = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        for (String a:template) {
            if (a.equals(cardsNumber)){
                return Integer.parseInt(cardsNumber);
            }
        }

        return -1;
    }

    private String validateCardValue (String cardValue){
        if (cardValue == null){
            return null;
        }

        if(cardValue.length() > 2){
            return null;
        }

        Utils validate = new Utils();

        if(validate.validateValue(cardValue)){
            return cardValue;
        }

        return null;
    }

    private boolean checkIfCardAlreadyChosen (int n, Card[] array, String cardValue) {
        for (int i = 0; i < n; i++) {
            if (array[i].getValue().equals(cardValue)) {
                return false;
            }
        }
        return true;
    }
}
