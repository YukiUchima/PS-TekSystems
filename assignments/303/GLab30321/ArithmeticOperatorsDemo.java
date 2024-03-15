package com.perscholas.java_basics;

//Guided Lab 303.2.1 - Core Java: Operators
public class ArithmeticOperatorsDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x, y = 10, z = 5;
        x = y + z;
        System.out.println("+ operator resulted in " + x);
        x = y - z;
        System.out.println("- operator resulted in " + x);
        x = y * z;
        System.out.println("* operator resulted in " + x);
        x = y / z;
        System.out.println("/ operator resulted in " + x);
        x = y % z;
        System.out.println("% operator resulted in " + x);
        x = y++;
        System.out.println("Postfix ++ operator resulted in " + x);
        x = ++z;
        System.out.println("Prefix ++ operator resulted in " + x);
        x = -y;
        System.out.println("Unary operator resulted in " + x);
        // Some examples of special Cases
        int tooBig = Integer.MAX_VALUE + 1; // -2147483648 which is
        // Integer.MIN_VALUE.
        int tooSmall = Integer.MIN_VALUE - 1; // 2147483647 which is
        // Integer.MAX_VALUE.
        System.out.println("tooBig becomes " + tooBig);
        System.out.println("tooSmall becomes " + tooSmall);

        System.out.println(4.0 / 0.0); // Prints: Infinity
        System.out.println(-4.0 / 0.0); // Prints: -Infinity
        System.out.println(0.0 / 0.0); // Prints: NaN
        double d1 = 12 / 8; // result: 1 by integer division. The value of d1 becomes 1.0.
        double d2 = 12.0F / 8; // result: 1.5
        System.out.println("d1 is " + d1);
        System.out.println("d2 is " + d2);
    }
}
