package glab303114;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> firstExample = new LinkedList<>();

        firstExample.add("Item1");
        firstExample.add("Item5");
        firstExample.add("Item3");
        firstExample.add("Item6");
        firstExample.add("Item2");

        System.out.println("Contents: " + firstExample);

        firstExample.addFirst("First Item");
        firstExample.addLast("Last Item");
        System.out.println("LinkedList Content after addition: " +firstExample);

        Object firstVar = firstExample.get(0);
        System.out.println("First value: " + firstVar);

        firstExample.set(0, "Changed first");
        System.out.println("First value changed: " + firstVar);


        firstExample.removeFirst();
        firstExample.removeLast();

        System.out.printf("Removed first and last: %s\n", firstExample);

//        Example Two: How to Sort LinkedList
        LinkedList<String> secondExample = new LinkedList<>();
        secondExample.add("A");
        secondExample.add("C");
        secondExample.add("B");
        secondExample.add("D");

        System.out.println(secondExample);
        Collections.sort(secondExample);

        System.out.println("Sorted " + secondExample);

        Collections.sort(secondExample, Collections.reverseOrder());

        System.out.println(secondExample);


    }
}
