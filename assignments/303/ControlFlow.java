package pa30341;

import java.util.*;

import static java.util.Map.entry;

//PA 303.4.1  - Practice Assignment
//Control Flow (Conditional) Statements
public class ControlFlow {

    public static void main(String[] args) {

//        qOne();
//        qTwo();
//        qThree();
//        qFour();
//        qFive();
//        qSix();
        qSeven();
    }

    private static void qOne() {

//        1. Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if statement to
//        print out “Less than 10” if x is less than 10. Change x to equal 15, and notice the result (console should
//        not display anything).

        int x = 7;
        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        }

    }

    private static void qTwo() {
//        2. Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if-else statement
//        that prints out “Less than 10” if x is less than 10, and “Greater than 10” if x is greater than 10. Change
//        x to 15 and notice the result.

        int x = 7;
        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if (x > 10) {
            System.out.println("Greater than 10");
        }
    }

    private static void qThree() {
//        3. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else-if
//        statement that prints out “Less than 10” if x is less than 10; “Between 10 and 20” if x is greater than 10
//        but less than 20, and “Greater than or equal to 20” if x is greater than or equal to 20. Change x to 50 and
//        notice the result.

        int x = 15;
        x = 50;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if (x > 10 && x < 20) {
            System.out.println("Between 10 and 20");
        } else {
            System.out.println("Greater than or equal to 20");
        }
    }

    private static void qFour() {
//        4. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else
//        statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range”
//        if the number is between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.

        int x = 15;
        x = 5;
        if (x < 10 || x > 20) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }
    }

    private static void qFive() {
//        5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F, according to the
//        following criteria:
//        A: 90-100
//        B: 80-89
//        C: 70-79
//        D: 60-69
//        F: <60
//        Use the Scanner class to accept a number score from the user to determine the letter grade. Print out
//        “Score out of range” if the score is less than 0 or greater than 100.

        Scanner input = new Scanner(System.in);
        System.out.println("Type score from 0 to 100: ");
        int score = input.nextInt();
        String grade;

        if (score >= 90 && score <= 100) {
            grade = "A";
        } else if (score >= 80 && score < 90) {
            grade = "B";
        } else if (score >= 70 && score < 80) {
            grade = "C";
        } else if (score >= 60 && score < 70) {
            grade = "D";
        } else if (score < 60 && score >= 0) {
            grade = "F";
        } else {
            grade = "Score out of range";
        }
        System.out.println(grade);

        input.close();
    }

    private static void qSix() {
//        6. Write a program that accepts an integer between 1 and 7 from the user. Use a switch statement to print
//        out the corresponding weekday. Print “Out of range” if the number is less than 1 or greater than 7. Do not
//        forget to include “break” statements in each of your cases.
        Scanner input = new Scanner(System.in);
        System.out.println("Type a number from 1 - 7: ");
        int day = input.nextInt();

        String weekday = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Out of range";
        };
        System.out.println(weekday);
        input.close();
    }

    private static void qSeven() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Tax Filing Estimator");
            System.out.println("Pick your filing status: (a) - single \t(b) - married, jointly \t(c) - married, " +
                    "separately \t(d) - head of household");
            String status = input.nextLine();
            System.out.println("Type in your current salary: ");
            int salary = input.nextInt();
            enum FilingStatus {SINGLE, MARRIED_JOINTLY, MARRIED_SEPARATELY, HEAD}

            Integer[] singleSalary = {0, 8350, 33950, 82250, 171550, 372950};
            Integer[] marriedJointlySalary = {0, 16700, 67900, 137050, 208850, 372950};
            Integer[] marriedSeparateSalary = {0, 8350, 33950, 68525, 104425, 186475};
            Integer[] householdSalary = {0, 11950, 45500, 117450, 190200, 372950};

            Map<FilingStatus, Integer[]> salaries = Map.ofEntries(
                    entry(FilingStatus.SINGLE, singleSalary),
                    entry(FilingStatus.MARRIED_JOINTLY, marriedJointlySalary),
                    entry(FilingStatus.MARRIED_SEPARATELY, marriedSeparateSalary),
                    entry(FilingStatus.HEAD, householdSalary)
            );

            int taxRate = switch (status) {
                case "a" -> calculateTaxBracket(salaries.get(FilingStatus.SINGLE), salary);
                case "b" -> calculateTaxBracket(salaries.get(FilingStatus.MARRIED_JOINTLY), salary);
                case "c" -> calculateTaxBracket(salaries.get(FilingStatus.MARRIED_SEPARATELY), salary);
                case "d" -> calculateTaxBracket(salaries.get(FilingStatus.HEAD), salary);
                default -> 0;
            };

            if (taxRate != 0) {
                System.out.println("Tax rate is " + taxRate + "%!");
            } else {
                System.out.println("Looks like you put in invalid input... Try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, try again!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }

    private static int calculateTaxBracket(Integer[] range, int salary) {
        Integer[] taxRates = {10, 15, 25, 28, 33, 35};
        for (int i = 1; i < range.length; i++) {
            if (range[i] > salary) {
                return taxRates[i-1];
            }
        }
        return 35;
    }
}
