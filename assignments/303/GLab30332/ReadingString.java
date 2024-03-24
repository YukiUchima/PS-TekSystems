import java.util.Scanner;
//Guided Lab 303.3.2 - Reading a String From the Console

public class Glab30332 {


    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        exampleOne(userIn);
        exampleTwo(userIn);
        userIn.close();
    }

    private static void exampleOne(Scanner input) {
        System.out.print("Enter three words separated by spaces: ");
        String s1 = input.next();
        String s2 = input.next();
        String s3 = input.next();
        input.nextLine();
        System.out.println("s1 is " + s1);
        System.out.println("s2 is " + s2);
        System.out.println("s3 is " + s3);
    }

    public static void exampleTwo(Scanner input) {

        System.out.print("Enter a character: ");
        String s = input.nextLine();
        char ch = s.charAt(0);
        System.out.println("The character entered is " + ch);

    }

}
