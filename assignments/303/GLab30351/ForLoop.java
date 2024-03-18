package glab30351;

import java.util.Scanner;

//Guided LAB - 303.5.1 - for loop
public class ForLoop {

    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
        exampleFour();
    }

    private static void exampleFour() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();//new line
        }
    }

    private static void exampleThree() {
        String original, reverse = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)) {
            System.out.println("Entered string/number is a palindrome.");
        } else {
            System.out.println("Entered string/number isn't a palindrome.");
        }

        in.close();

    }

    private static void exampleTwo() {
        int sum = 0;
        int n = 1000;
        // for loop
        for (int i = 1; i <= n; ++i) {
            // body inside for loop
            sum += i;     // sum = sum + i
        }
        System.out.println("Sum = " + sum);

    }

    private static void exampleOne() {
        int n = 5;
        // for loop
        for (int i = 1; i <= n; ++i) {
            System.out.println("Java is fun");
        }
    }


}
