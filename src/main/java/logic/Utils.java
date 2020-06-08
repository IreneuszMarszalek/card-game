package logic;

import data.Card;

public class Utils {
    private final static String[] cardColorDesc = {"Pik", "Kier", "Karo", "Trefl"}; //pik (wino), kier (czerwień), karo (dzwonek), trefl (żołądź)
    private final static byte[] cardColorSeniority = {4,3,2,1}; //bigger older, smaller younger

    private final static String[] cardValueDesc = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final static byte[] cardValueSeniority = {1,2,3,4,5,6,7,8,9,10,11,12,13}; //bigger older, smaller younger

    public boolean validateColor(String color){
        if (color == null){
            return false;
        }

        for (String a: cardColorDesc) {
            if (color.equals(a)){
                return true;
            }
        }
        return false;
    }

    public boolean validateValue(String value){
        if (value == null){
            return false;
        }

        for (String a:cardValueDesc) {
            if(value.equals(a)){
                return true;
            }
        }
        return false;
    }

    private byte getIndexColorSeniority(String color){
        if (color == null){
            return -1;
        }

        byte index = 0;

        if(validateColor(color)){
            for (String a:cardColorDesc) {
                if (a.equals(color)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public byte getColorSeniority(Card card){
        if (card.getColor() == null){
            return -1;
        }

        Utils validator = new Utils();
        byte index;

        if(validator.validateColor(card.getColor())){
            index = getIndexColorSeniority(card.getColor());
            if (index != -1){
                return cardColorSeniority[index];
            }
        }
        return -1;
    }

    private byte getIndexValueSeniority(String value){
        if (value == null){
            return -1;
        }
        byte index = 0;

        if(validateValue(value)){
            for (String a:cardValueDesc) {
                if (a.equals(value)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public byte getValueSeniority(Card card){
        if (card.getValue() == null){
            return -1;
        }

        byte index;
        Utils validator = new Utils();

        if(validator.validateValue(card.getValue())){
            index = getIndexValueSeniority(card.getValue());
            if (index != -1){
                return cardValueSeniority[index];
            }
        }
        return -1;
    }

    public void displayCard(Card card){
        System.out.println(card.getValue() + " " + card.getColor());
    }
}
