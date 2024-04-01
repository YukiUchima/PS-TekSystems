package glab303115;

import java.util.HashSet;

public class exampleTwo {

    public static void main(String[] args) {
        //    Guided LAB - 303.11.5 - HashSet and TreeSet Processing
        HashSet<Integer> evenNumbers = new HashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("HashSet1: " + evenNumbers);

        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(3);
        System.out.println("HashSet2: " + numbers);

        // Union of two set
        numbers.addAll(evenNumbers);
        System.out.println("Union is: " + numbers);

    }
}
