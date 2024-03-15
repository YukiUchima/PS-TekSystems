package com.perscholas.java_basics;
//Guided Lab 303.2.1 - Core Java: Operators
public class LogicalOperatorsDemo {

    public static void main(String[] args)
    {
        boolean x = true;
        boolean y = false;
        System.out.println("x & y : " + (x & y));
        System.out.println("x && y : " + (x && y));
        System.out.println("x | y : " + (x | y));
        System.out.println("x || y: " + (x || y));
        System.out.println("x ^ y : " + (x ^ y));
        System.out.println("!x : " + (!x));
    }

}
