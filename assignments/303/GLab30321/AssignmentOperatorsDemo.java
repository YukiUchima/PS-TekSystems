package com.perscholas.java_basics;
//Guided Lab 303.2.1 - Core Java: Operators

public class AssignmentOperatorsDemo {

    public static void main(String args[]) {
        //   Assigning Primitive Values
        int j, k;
        j = 10; // j gets the value 10.
        j = 5; // j gets the value 5. The previous value is overwritten.
        k = j; // k gets the value 5.
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);

        //              Multiple Assignments
        k = j = 10; // (k = (j = 10))
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);
    }

}
