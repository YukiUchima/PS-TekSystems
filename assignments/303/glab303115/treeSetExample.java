package glab303115;

import java.util.Iterator;
import java.util.TreeSet;

public class treeSetExample {
    //    Guided LAB - 303.11.5 - HashSet and TreeSet Processing


    public static void main(String[] args) {

//        treeExampleOne();
//        exampleTwoThree();
        exampleFourHelper();
    }

    private static void exampleTwoThree() {
//        Example of removal in treeSet
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("\nTreeSet: " + numbers);

        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        // Using the removeAll() method
//        boolean value2 = numbers.removeAll(numbers);
//        System.out.println("Are all elements removed? " + value2);


        // Example if navigating tree
        int first = numbers.first();
        int last = numbers.last();
        System.out.printf("First: %d and Last: %d", first, last);
    }

    private static void treeExampleOne() {
        TreeSet<Integer> num_Treeset = new TreeSet<>();
        num_Treeset.add(20);
        num_Treeset.add(5);
        num_Treeset.add(15);
        num_Treeset.add(25);
        num_Treeset.add(10);

        // Call iterator() method to define Iterator for TreeSet
        Iterator<Integer> iter_set = num_Treeset.iterator();
        System.out.print("TreeSet using Iterator: ");
        // Access TreeSet elements using Iterator
        while (iter_set.hasNext()) {
            System.out.print(iter_set.next());
            System.out.print(", ");
        }
    }

    private static void exampleFourHelper() {
// Create a TreeSet with user-defined comparator
        TreeSet<String> cities = new TreeSet<>(new cities_comparator());
        //add elements to the comparator
        cities.add("UAE");
        cities.add("Mumbai");
        cities.add("NewYork");
        cities.add("Hyderabad");
        cities.add("Karachi");
        cities.add("Xanadu");
        cities.add("Lahore");
        cities.add("Zagazig");
        cities.add("Yingkou");

        //print the contents of TreeSet
        System.out.println("TreeSet: " + cities);

    }


}
