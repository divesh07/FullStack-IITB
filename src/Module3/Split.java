public class Split {
    public static void main(String[] args) {
        String sku = "HAH-CRNUB-12MT0-C1S";
        String[] splitSku = sku.split("-");
        boolean flag = false;
        if (splitSku[0].equalsIgnoreCase("HAH") && splitSku[1].substring(2, 4).equalsIgnoreCase("NU")) {
            flag = true;
        }
        System.out.println(flag);
    }
}
