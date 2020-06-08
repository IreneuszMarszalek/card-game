package data;

import logic.Utils;

public class Card {

    private String color;
    private String value;

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public Card(String color, String value) {
        boolean flag = true;
        Utils validator = new Utils();

        if(!validator.validateColor(color)){
            System.out.println("Incorrect card color");
            flag = false;
        }

        if(!validator.validateValue(value)){
            System.out.println("Incorrect card value");
            flag = false;
        }

        if(flag) {
            this.color = color;
            this.value = value;
        }
    }
}
