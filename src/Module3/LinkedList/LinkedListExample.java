package LinkedList;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();
        // Adds elements to the end
        friends.add("John");
        friends.add("Steve");
        friends.add("Andrad");
        friends.add("Rama");
        friends.add("Hanni");
        System.out.println(friends);

        // Add at specific position
        friends.add(3,"Cristiano");
        System.out.println(friends);

        // Add at start
        friends.addFirst("Begin");
        System.out.println(friends);

        // Add at end
        friends.addLast("End");
        System.out.println(friends);

        // Add a collection
        List<String> newList = new ArrayList<>();
        newList.add("one");
        newList.add("another");
        friends.addAll(newList);
        System.out.println(friends);

        // Retrieve
        LinkedList<Double> stockPrices = new LinkedList<>();
        stockPrices.add(45.00);
        stockPrices.add(51.00);
        stockPrices.add(62.50);
        stockPrices.add(42.75);
        stockPrices.add(36.80);
        stockPrices.add(68.40);
        System.out.println(stockPrices);
        // get first
        System.out.println(stockPrices.getFirst());
        System.out.println(stockPrices.getLast());
        System.out.println(stockPrices.get(2));

        // Remove Elements
        LinkedList<String> programmingLanguages = new LinkedList<>();

        programmingLanguages.add("Assembly");
        programmingLanguages.add("Fortran");
        programmingLanguages.add("Pascal");
        programmingLanguages.add("C");
        programmingLanguages.add("C#");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("C#");
        programmingLanguages.add("C++");
        programmingLanguages.add("Kotlin");
        System.out.println(programmingLanguages);

        programmingLanguages.removeFirst();
        System.out.println(programmingLanguages);
        programmingLanguages.removeLast();
        System.out.println(programmingLanguages);
        programmingLanguages.removeFirstOccurrence("C#");
        System.out.println(programmingLanguages);
        programmingLanguages.remove("C++");
        System.out.println(programmingLanguages);
        programmingLanguages.removeIf(s -> s.startsWith("C"));
        System.out.println(programmingLanguages);
        programmingLanguages.clear();
        System.out.println(programmingLanguages);

        // Search for elements:
        LinkedList<String> employees = new LinkedList<>();

        employees.add("John");
        employees.add("David");
        employees.add("Lara");
        employees.add("Chris");
        employees.add("Steve");
        employees.add("David");

        System.out.println(employees.contains("David"));
        System.out.println(employees.contains("Rama"));
        System.out.println(employees.indexOf("Steve"));
        System.out.println(employees.indexOf("Bob")); // -1 if not present
        System.out.println(employees.lastIndexOf("David"));

        // Iterating

        LinkedList<String> humanSpecies = new LinkedList<>();

        humanSpecies.add("Homo Sapiens");
        humanSpecies.add("Homo Neanderthalensis");
        humanSpecies.add("Homo Erectus");
        humanSpecies.add("Home Habilis");

        // iteration using lambda
        humanSpecies.forEach(name-> System.out.println(name));
        
        // using iterator
        Iterator<String> humanSpeciesIterator  = humanSpecies.iterator();
        while(humanSpeciesIterator.hasNext()){
            System.out.println(humanSpeciesIterator.next());
        }

        // prints backwards
        Iterator<String> descendingHumanSpeciesIterator = humanSpecies.descendingIterator();
        while (descendingHumanSpeciesIterator.hasNext()) {
            String speciesName = descendingHumanSpeciesIterator.next();
            System.out.println(speciesName);
        }

        // prints in normal order using List iterator
        Iterator<String> listIterator = humanSpecies.listIterator(0);
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        // prints in backwards order using List iterator
        Iterator<String> listBackIterator = humanSpecies.listIterator(humanSpecies.size());
        while (((ListIterator<String>) listIterator).hasPrevious()){
            System.out.println(((ListIterator<String>) listIterator).previous());
        }


    }
}




