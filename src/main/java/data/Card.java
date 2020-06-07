package data;

public class Card {
    private final static String[] cardColorDesc = {"Pik", "Kier", "Karo", "Trefl"}; //pik (wino), kier (czerwień), karo (dzwonek), trefl (żołądź)
    private final static byte[] cardColorSeniority = {4,3,2,1}; //bigger older, smaller younger

    private final static String[] cardValueDesc = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final static byte[] cardValueSeniority = {1,2,3,4,5,6,7,8,9,10,11,12,13}; //bigger older, smaller younger

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

        if(!validateColor(color)){
            System.out.println("Incorrect card color");
            flag = false;
        }

        if(!validateValue(value)){
            System.out.println("Incorrect card value");
            flag = false;
        }

        if(flag) {
            this.color = color;
            this.value = value;
        }
    }

    private boolean validateColor(String color){
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

    private boolean validateValue(String value){
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

    public byte getColorSeniority(){
        if (this.color == null){
            return -1;
        }

        byte index = 0;
        if(validateColor(this.color)){
            index = getIndexColorSeniority(this.color);
            if (index != -1){
                return cardColorSeniority[index];
            }
        }
        return -1;
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

    public byte getValueSeniority(){
        if (this.value == null){
            return -1;
        }

        byte index = 0;
        if(validateValue(this.value)){
            index = getIndexValueSeniority(this.value);
            if (index != -1){
                return cardValueSeniority[index];
            }
        }
        return -1;
    }

    public void displayCard(){
        System.out.println(this.getValue() + " " + this.getColor());
    }
}
