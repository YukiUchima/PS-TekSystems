package pa30351;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {

        createMultiTable();
        findGCD();
        findTuitionYear();

    }

    private static void createMultiTable() {
        //        1.) Create 12x12 multiplication table
        for (int i = 1; i <= 12; i++){
            for (int j = 1; j<=12; j++){
                int res = i * j;
                System.out.print("\t" + res);
            }
            System.out.println();
        }
    }

    private static void findGCD() {
        //        2.) Find GCD with between two input numbers

        Scanner input = new Scanner(System.in);
        System.out.println("Type two integers to solve for GCD: ");
        int num1 = Math.abs(input.nextInt());
        int num2 = Math.abs(input.nextInt());

        // method 1: =============================================================================
//        if (num1 < num2){
//            temp = num1;
//            num1 = num2;
//            num2 = temp;
//        }
//
//        while(num2 > 0){
//            temp = num2;
//            num2 = num1 % num2;
//            num1 = temp;
//        }

        // method 2: =============================================================================
        int gcd = 1;
        for(int k = 2; k <= Math.min(num1, num2); k++){
            if (num1 % k == 0 && num2 % k == 0 && gcd < k){
                gcd = k;
            }
        }
        System.out.println("GCD is: " + gcd);

        input.close();
    }

    private static void findTuitionYear() {
        //      3.) Predict year when tuition is double
        int tuition = 10000;
        double increase = 0.07 + 1;
        int target = tuition * 2;
        int years = 0;

        while (tuition < target){
            years++;
            tuition *= increase;
        }
        System.out.println("Tuition doubled after " + years + " year(s)");
    }
}
