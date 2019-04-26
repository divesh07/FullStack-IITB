
public class Debug {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(10);
        int totalPrice = ticket.calculateCost(100);
        System.out.println(totalPrice);

        Person person = new Person();
        person.setName("Ankit");
        System.out.println(person.getName());
    }
}

class MovieTicket {
    public int singleTicketCost;

    public MovieTicket(int singleTicketCost) {
        this.singleTicketCost = singleTicketCost;
    }

    public int calculateCost(int quantity) {
        return quantity * singleTicketCost;
    }
}

class Person {
    private String name;

    // Declare a getter method here
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}