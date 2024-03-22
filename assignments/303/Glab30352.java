package glab30351;

import java.util.Scanner;

public class Glab30352 {

    public static void main(String[] args) {
//        example1();
//        example2();
        example3();
    }


    private static void example1() {

        Scanner input = new Scanner(System.in);
        int randNum = (int) (Math.random() * 101);
        System.out.println("Guess the Number! (ans: " + randNum + " )");
        int guess;

        do {
            System.out.println("Enter the number: ");
            guess = Integer.parseInt(input.nextLine());
            if (guess < randNum) {
                System.out.println("Guess is low");
            }
            if (guess > randNum) {
                System.out.println("Guess is high");
            }
        }
        while (guess != randNum);
        System.out.println("You guessed the correct number " + randNum + "!");
        input.close();
    }

    private static void example2() {
        System.out.println("Solve FIVE problems!");
        Scanner input = new Scanner(System.in);
        int questions = 3;
        int questionsLeft = questions;
        int correct = 0;

        while(questionsLeft > 0){
            int num1 = (int) (Math.random() * 10);
            int num2 = (int) (Math.random() * 10);
            int ans = num1 - num2;
            System.out.printf("What is %d - %d ?\n", num1, num2);
            int userAnswer = Integer.parseInt(input.nextLine());
            if (ans == userAnswer){
                System.out.println("You are correct!");
                correct++;
            }
            questionsLeft--;
        }
        System.out.printf("You scored a %d out of %d.", correct, questions);
        input.close();
    }

    private static void example3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers you would like to sum up. (0) to exit!");
        int sum = 0;
        int num = input.nextInt();

        while (num != 0){
            sum += num;
            num = input.nextInt();
        }

        System.out.println("Your sum is: " + sum);


        input.close();
    }
}
