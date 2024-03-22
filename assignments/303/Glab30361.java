import java.util.Scanner;

public class Glab30361 {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
        example4();
        example5();
        example6();


    }

    private static void example1() {

        int[] age = {12, 4, 5, 2, 5};

        System.out.println("Accessing Elements of an Array:");
        System.out.println("First Element: " + age[0]);
        System.out.println("Second Element: " + age[1]);
        System.out.println("Third Element: " + age[2]);
        System.out.println("Fourth Element: " + age[3]);
        System.out.println("Fifth Element: " + age[4]);
    }

    private static void example2() {

        int[] age = {12, 4, 5};


        System.out.println("Using for Loop:");
        for (int i = 0; i < age.length; i++) {
            System.out.print(age[i] + " ");
        }
        System.out.println();

    }

    private static void example3() {
        String[] names = {"New York", "Dallas", "Las Vegas", "Florida"};
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    private static void example4() {

        int[] numbers = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
        int sum = 0;
        Double avg;

        for (int number : numbers) {
            sum += number;
        }

        int arrayLength = numbers.length;

        avg = ((double) sum / (double) arrayLength);

        System.out.println("Sum = " + sum);
        System.out.printf("Average = %.2f %n", avg);
    }

    private static void example5() {
        int[] marks = {74, 43, 58, 60, 90, 64, 70};
        int sum = 0;
        int sumSq = 0;
        double mean, stdDev;

        for (int i = 0; i < marks.length; ++i) {
            sum += marks[i];
            sumSq += marks[i] * marks[i];
        }
        mean = (double) sum / marks.length;
        stdDev = Math.sqrt((double) sumSq / marks.length - mean * mean);

        System.out.printf("Mean is: %.2f%n", mean);
        System.out.printf("Standard deviation is: %.2f%n", stdDev);
    }

    private static void example6() {
        int i, element;
        int[] arr = new int[11];
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter %s Elements: ", arr.length-1);
        for (i = 0; i < 10; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter an Element to Insert: ");
        element = input.nextInt();
        arr[i] = element;

        System.out.println("\nNow the new array is: ");
        for (i = 0; i < 11; i++)
            System.out.print(arr[i] + " ");

        input.close();

    }

}
