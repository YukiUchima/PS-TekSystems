package glab30311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateArrayListExample {

    public static void main(String[] args) {
//        Example 1: Creating an ArrayList and Adding New Elements
        List<String> animals = new ArrayList<>();

        animals.add("Lion");
        animals.add("Elphant");
        animals.add("Black Panther");
        animals.add("Turtle");

        System.out.println(animals);

        animals.add(2, "Blue Whale");
        System.out.println(animals);



//        Example 2: Creating an ArrayList From Another Collection
        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);

        List<Integer> tenPrimeNumbers = new ArrayList<>(firstFivePrimeNumbers);

        List<Integer> nextFivePM = new ArrayList<>();
        nextFivePM.add(13);
        nextFivePM.add(17);
        nextFivePM.add(19);
        nextFivePM.add(23);
        nextFivePM.add(29);

        tenPrimeNumbers.addAll(nextFivePM);

        System.out.println(tenPrimeNumbers);



    }
}
