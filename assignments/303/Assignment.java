package com.perscholas.java_basics;
// PA 303.2.1 - Practice Assignment Core Java - Variables

public class Assignment {

    public static void main(String[] args) {

//        Write a program that declares two integer variables, assigns an integer to each, and adds them together.
//        Assign the sum to a variable. Print out the result.

        int num2 = 2;
        int num11 = 11;
        int res1 = num2 + num11;
        System.out.println("Sum: " + res1);

//        Write a program that declares two double variables, assigns a number to each, and adds them together.
//        Assign the sum to a variable. Print out the result.

        double dNum2 = 10.2;
        double dNum = 3.2;
        double res2 = dNum + dNum2;
        System.out.println("Double sum: " + res2);

//         Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds
//         them together. Assign the sum to a variable. Print out the result. What variable type must the sum be?
        double res3 = dNum + num2;
        System.out.println("Double and int sum is a double result: " + res3);

//         Write a program that declares two integer variables, assigns an integer to each, and divides the larger
//         number by the smaller number. Assign the result to a variable. Print out the result. Now change the larger
//         number to a decimal. What happens? What corrections are needed?

        int res4 = num11 / num2;
        System.out.println(res4);
        double res5 = (double) num11 / num2;
        System.out.println("Type cast to get accurate result: " + res5);

//         Write a program that declares two double variables, assigns a number to each, and divides the larger by
//         the smaller number. Assign the result to a variable. Print out the result. Now, cast the result to an
//         integer. Print out the result again.
        double res6 = dNum2 / dNum;
        System.out.println("Division: " + res6);
        System.out.println("Division cast int: " + (int)res6);

//         Write a program that declares two integer variables, x and y, and assigns the number 5 to x and the number
//         6 to y. Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign it to q.
//         Print q again.
        int x = 5;
        int y = 6;
        double q = y / x;
        System.out.println("q value: " + q);
        q = (double)y / x;
        System.out.println("q with double cast: " + q);

//         Write a program that declares a named constant and uses it in a calculation. Print the result.
        final int X_VALUE = 10;
        double result = X_VALUE / num2;
        System.out.println("Constant calculation: " + result);

//         Write a program where you create three variables that represent products at a cafe. The products could be
//         beverages like coffee, cappuccino, espresso, green tea, etc. Assign prices to each product. Create two more
//         variables called subtotal and totalSale and complete an “order” for three items of the first product, four
//         items of the second product, and two items of the third product. Add them all together to calculate the
//         subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale
//         amount. Be sure to format the results to two decimal places.

        double latte = 2.99;
        double espresso = 8.45;
        double tea = 4.75;
        double subtotal;
        double totalSale;

        subtotal = latte * 3 + 4 * espresso + 2 * tea;
        final double SALES_TAX = 3.7 / 100;

        totalSale = subtotal + subtotal * (SALES_TAX);
//        Format amount to two decimal places
        System.out.printf("Total cost (/w tax): %.2f", totalSale);
    }
}
