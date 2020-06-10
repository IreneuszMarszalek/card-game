package logic;

import data.Card;

import java.util.Arrays;

public class Game {
    public Card[] sortCardsByValue(Card[] array){
       int[] cardsSeniorityArray = {99,99,99,99,99,99,99,99,99,99,99,99,99};
       int index=0;
       Utils utils = new Utils();

       for (Card a:array) {
            if (a == null){
                break;
            }
            cardsSeniorityArray[index] = utils.getValueSeniority(a);
            index++;
        }

        Arrays.sort(cardsSeniorityArray);

        index = 0;
        Card[] temp = new Card[13];
        int tempIndex;
        for (int a:cardsSeniorityArray) {
            if (a == 99){
                break  ;
            }
            tempIndex = utils.getIndexSeniorityValue(a);
            temp[index] = new Card("Pik", utils.getValueByIndex(tempIndex));
            index++;
        }

        return temp;
    }
}
