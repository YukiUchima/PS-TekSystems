package glab303115;

import java.util.HashSet;

public class exampleOne {
    //    Guided LAB - 303.11.5 - HashSet and TreeSet Processing
    public static void main(String[] args) {
        HashSet<Integer> evenNumber = new HashSet<>();

        evenNumber.add(2);
        evenNumber.add(4);
        evenNumber.add(6);


        System.out.println("Hashset: " + evenNumber);

//        addAll() method
        HashSet<Integer> numbers = new HashSet<>(evenNumber);
//        numbers.addAll(evenNumber);
        numbers.add(5);
        System.out.println("Added all hashset: " + numbers);

    }
}
