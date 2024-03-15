package com.perscholas.java_basics;
//Guided Lab 303.2.1 - Core Java: Operators
public class BitwiseOperatorsDemo {

    public static void main(String[] args)
    {
        int x = 58; //111010
        int y =13; //1101
        System.out.println("x & y : " + (x & y)); //returns 8 = 1000
        System.out.println("x | y : " + (x | y)); //63=111111
        System.out.println("x ^ y : " + (x ^ y)); //55=11011
        System.out.println("~x : " + (~x));  //-59
        System.out.println("x << y : " + (x << y));
        System.out.println("x >> y : " + (x >> y));
    }

}
