package Test;

public class Test {
    public static void main(String[] args) {
        //String sku = "HAH-CRNUA-12PT0-C1S";

        String sku = "HAH-ADNUA-12PT0-C1S";
        String[] splitSku = sku.split("-");
        String str = splitSku[1].substring(0, 2);
        boolean ifUserLicense = splitSku[0].equalsIgnoreCase("HAH") && splitSku[1].substring(0, 2).equalsIgnoreCase("AD");
        System.out.println(ifUserLicense);
        System.out.println(str);

        int x = 10;
        if ( x == 5){
            System.out.println("5");
        }else if (x > 5){
            System.out.println("greater than 5");
        }

    }
}
