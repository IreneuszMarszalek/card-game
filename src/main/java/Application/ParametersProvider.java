package Application;

import data.Parameters;
import logic.Utils;

import java.util.Scanner;

public class ParametersProvider {
    public Parameters fetchParameters(){
        Scanner scanner = new Scanner(System.in);

        String temp;
        int numberOfCards;
        String[] cardsValue = new String[13];
        do{
            System.out.print("Provide the number of cards <1-13>: ");
            temp = scanner.nextLine();
            numberOfCards = validateCardsNumber(temp);
        }while (numberOfCards == -1);

        for (int i = 1; i <= numberOfCards; i++) {
            //TODO: check if cars was already provided
            do{
                System.out.print("Provide card " + i + "/" + numberOfCards + " value <2,3,4,5,6,7,8,9,10,J,Q,K,A>:");
                temp = scanner.nextLine();
                cardsValue[i-1] = validateCardValue(temp);
            }while(cardsValue[i-1] == null);
        }

        return new Parameters(numberOfCards, cardsValue);
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
}
