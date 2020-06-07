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

        if(validateColor(color)){
            this.color = color;
        }else{
            System.out.println("Incorrect card color");
            flag = false;
        }

        if (flag){
            if(validateValue(value)){
                this.value = value;
            }else {
                System.out.println("Incorrect card value");
            }
        }
    }

    private static boolean validateColor(String color){
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

    private static boolean validateValue(String value){
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
}
