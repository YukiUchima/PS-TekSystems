package pa30371;

import java.util.*;

//PA 303.7.1 - Practice Assignment - Array
public class PA30371 {

    public static void main(String[] args) {
//        taskOne();
//        taskTwo();
//        taskThree();
//        taskFour();
//        taskFive();
//        taskSix();
//        taskSeven();
//        taskEight();
//        taskNine();
//        taskTen();
        taskEleven();
    }


    private static void taskOne() {
        // Task 1: Write a program that creates an array of integers with a length of 3. Assign the values 1, 2, and 3
        // to the indexes. Print out each array element.
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

    }

    private static void taskTwo() {
        //Task 2: Write a program that returns the middle element in an array. Give the following values to the integer
        // array: {13, 5, 7, 68, 2} and produce the following output: 7
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] arr = {13, 5, 7, 68, 2};
        int middle = arr.length / 2;
        System.out.println("Middle of array: " + arr[middle]);
    }

    private static void taskThree() {
        //Task 3: Write a program that creates an array of String type and initializes it with the strings “red,”
        // “green,” “blue,” and “yellow.” Print out the array length. Make a copy using the clone( ) method. Use the
        // Arrays .toString() method on the new array to verify that the original array was copied.
        System.out.println("\nTask: " +
                "===================================================================================");
        String[] arr = {"red", "green", "blue", "yellow"};
        System.out.println("Array length: " + arr.length);

//        String[] newArr = arr.clone();
        String[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("New array: " + Arrays.toString(newArr));

    }

    private static void taskFour() {
        //Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers). The numbers can be any
        // integers.  Print out the value at the first index and the last index using length - 1 as the index. Now try
        // printing the value at index = length (e.g., myArray[myArray.length] ).  Notice the type of exception which is
        // produced. Now try to assign a value to the array index 5. You should get the same type of exception.
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] intArr = new Integer[5];
        for (int i = 0; i < intArr.length; i++) {
            int num = (int) (Math.random() * 100) + 1;
            intArr[i] = num;
        }
        System.out.println("Created array: " + Arrays.toString(intArr));
        int firstIndex = intArr[0];
        int lastIndex = intArr[intArr.length - 1];
        System.out.println("First index: " + firstIndex);
        System.out.println("Last index: " + lastIndex);

        // Attempt to access 5th index
        try {
            intArr[5] = 2; //exception index out of bounds
            System.out.println("5th index: " + intArr[5]); //exception index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Issue where index out of bounds. Error Msg:\t" + e.getMessage());
        } catch (Exception e) {
            // catch-all
            System.out.println(e.getMessage());
        }


    }

    private static void taskFive() {
        //Task 5: Write a program where you create an integer array with a length of 5. Loop through the array and
        // assign the value of the loop control variable (e.g., i) to the corresponding index in the array.
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] arr = new Integer[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("Array: " + Arrays.toString(arr));
    }

    private static void taskSix() {
        //Task 6: Write a program where you create an integer array of 5 numbers. Loop through the array and assign
        // the value of the loop control variable multiplied by 2 to the corresponding index in the array.
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] arr = new Integer[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        System.out.println("Array: " + Arrays.toString(arr));

    }

    private static void taskSeven() {
        //Task 7: Write a program where you create an array of 5 elements. Loop through the array and print the value
        // of each element, except for the middle (index 2) element.
        System.out.println("\nTask: " +
                "===================================================================================");
        int size = 5;
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 50);
            if (i != size / 2) {
                System.out.print(i + " ");
            }
        }
    }

    private static void taskEight() {
        //Task 8: Write a program that creates a String array of 5 elements and swaps the first element with the middle
        //  element without creating a new array.
        System.out.println("\nTask: " +
                "===================================================================================");
        int size = 5;
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 50);
        }
        System.out.print("Original array: ");
        System.out.println(Arrays.toString(arr));
        int middle = size / 2;
        int temp = arr[0];
        int arrMid = arr[middle];
        arr[0] = arrMid;
        arr[middle] = temp;

        System.out.print("Updated array: ");
        System.out.println(Arrays.toString(arr));


    }

    private static void taskNine() {
        //Task 9: Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. Print the
        // array in ascending order, and print the smallest and the largest element of the array. The output will
        // look like the following: Array in ascending order: 0, 1, 2, 4, 9, 13 The smallest number is 0 The biggest
        // number is 13
        System.out.println("\nTask: " +
                "===================================================================================");
        Integer[] arr = {4, 2, 9, 13, 1, 0};
        // Sorts original array
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Lowest value: " + arr[0]);
        System.out.println("Largest value: " + arr[arr.length - 1]);
    }

    private static void taskTen() {
        //Task 10: Create an array that includes an integer, 3 strings, and 1 double. Print the array.
        System.out.println("\nTask: " +
                "===================================================================================");
        ArrayList<Object> arr = new ArrayList<>();
        arr.add((231));
        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add(6.024D);

        System.out.println(arr);
    }

    private static void taskEleven() {
        //Task 11: Write some Java code that asks the user how many favorite things they have. Based on their answer,
        // you should create a String array of the correct size. Then ask the user to enter the things and store them
        // in the array you created. Finally, print out the contents of the array.
        // Example
        //How many favorite things do you have?
        //7
        //
        //Enter your thing: phone
        //Enter your thing: tv
        //Enter your thing: xbox
        //Enter your thing: wine
        //Enter your thing: beer
        //Enter your thing: sofa
        //Enter your thing: book
        //Your favorite  things are:
        //phone tv xbox wine beer sofa book
        System.out.println("\nTask: " +
                "===================================================================================");
        try {

            Scanner input = new Scanner(System.in);
            System.out.println("How many favorite objects do you have? ");

            int size = input.nextInt();
            //Go to next line after integer
            input.nextLine();
            //Create array
            String[] favorites = new String[size];
            System.out.println("Tell me an object in your list: ");

            if (size > 0) {
                while (size > 0) {
                    System.out.print("Enter your favorite thing: ");
                    favorites[size - 1] = input.nextLine();
                    size--;
                }
                System.out.print("Your favorite things are:\n");
                for (String item : favorites) {
                    System.out.print(item + " ");
                }
            } else {
                System.out.println("That's a bummer.");
            }


        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
