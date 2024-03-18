package com.perscholas.java_basics;
// Guided LAB 303.2.2 - Core Java: Type Casting
public class AutoTypeConversion {
    public static void main(String[] args) {
        int x = 20;
        double y = 40.5;

        long p = 30;
        float q = 10.60f;
        // int z = x + y; (1) // Error; cannot convert from double to int.
        double z = x + y;
        System.out.println("Sum of two numbers: " + z);

        // long r = p - q; // (2) // Error; cannot convert from float to long.
        float r = p - q;
        System.out.println("Subtraction of two numbers: " + r);
    }

}
