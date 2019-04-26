package session1.Inheritance.test;


class Mammal {
    public static String speak() {
        return "ohlllalalalalalaoaoaoa";
    }

    public static class Cat extends Mammal {

        public  static String speak() {
            return "Meow";
        }
    }

    public static void main(String[] args) {
        Mammal mammal1 = new Mammal();
        System.out.println(mammal1.speak());
        Mammal cat = new Cat();
        System.out.println(cat.speak());
    }

}
