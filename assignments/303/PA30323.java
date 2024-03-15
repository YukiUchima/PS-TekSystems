package com.perscholas.java_basics;
//PA - 303.2.3 - Practice Assignment Operators and Numbers
//Operators and numbers
public class PA30323 {

    public static void main(String[] args) {
//        Write a program that declares an integer a variable x, assigns the value 2 to it, and prints out the binary
//        string version of the number ( Integer.toBinaryString(x) ). Now, use the left shift operator (<<) to shift
//        by 1 and assign the result to x. Before printing the results, write a comment with the predicted decimal
//        value and binary string. Now, print out x in decimal form and in binary notation.
//                Perform the preceding exercise with the following values:
//        9
//        17
//        88

        int x = 9;
        System.out.println("x = 9: " + Integer.toBinaryString(x));
        x = x << 1;
//        Predicted output:
//        10010
//        18.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

        x = 17;
        System.out.println("x = 17: " + Integer.toBinaryString(x));
        x = x << 1;
//        Predicted output:
//        100010
//        34.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

        x = 88;
        System.out.println("x = 88: " + Integer.toBinaryString(x));
        x = x << 1;
//        Predicted output:
//        10110000
//        176.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);



//        Write a program that declares a variable x, and assigns 150 to it, and prints out the binary string version
//        of the number. Now use the right shift operator (>>) to shift by 2 and assign the result to x. Write a
//        comment indicating what you anticipate the decimal and binary values to be. Now print the value of x and
//        the binary string.
//        Perform the preceding exercise with the following values:
//        225
//        1555
//        32456

        x = 150;
        System.out.println("x = 150: " + Integer.toBinaryString(x));
        x = x << 2;
//        Predicted output:
//        1001011000
//        600.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

        x = 225;
        System.out.println("x = 225: " + Integer.toBinaryString(x));
        x = x << 2;
//        Predicted output:
//        1110000100
//        900.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

        x = 1555;
        System.out.println("x = 1555: " + Integer.toBinaryString(x));
        x = x << 2;
//        Predicted output:
//        1100001001100
//        6220.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

        x = 32456;
        System.out.println("x = 32456: " + Integer.toBinaryString(x));
        x = x << 2;
//        Predicted output:
//        11111101100100000
//        129824.0
        System.out.println(Integer.toBinaryString(x));
        System.out.println((double)x);

//        Write a program that declares three int variables: x, y, and z. Assign 7 to x and 17 to y. Write a comment
//        that indicates what you predict will be the result of the bitwise and operation on x and y. Now use the
//        bitwise AND (&) operator to derive the decimal and binary values, and assign the result to z.
        x = 7;          // 00111
        int y = 17;     // 10001
        int z = x & y;  // 00001 => 1.0
        System.out.println((double)z);

//        Now, with the preceding values, use the bitwise and operator to calculate the “or” value between x
//        and y. As before, write a comment that indicates what you predict the values to be before printing
//        them out.

//        OR result:    // 10111 => 23.0
        z = x | y;
        System.out.println((double)z);



//        Write a program that declares an integer variable, assigns a number, and uses a postfix increment
//        operator to increase the value. Print the value before and after the increment operator.

        int postFix = 11;
        System.out.println(postFix);
        postFix++;
        System.out.println(postFix);


//        Write a program that demonstrates at least three ways to increment a variable by 1 and does this
//        multiple times. Assign a value to an integer variable, print it, increment by 1, print it again,
//        increment by 1, and then print it again.

        int incrementNum = 1;
        incrementNum++;
        System.out.println(incrementNum);
        incrementNum += 1;
        System.out.println(incrementNum);
        incrementNum = incrementNum + 1;
        System.out.println(incrementNum);



//        Write a program that declares two integer variables: x, and y, and then assigns 5 to x and 8 to y. Create
//        another variable sum and assign the value of ++x added to y, and print the result. Notice the value of the
//        sum (should be 14). Now change the increment operator to postfix (x++) and re-run the program. Notice what
//        the value of the sum is. The first configuration incremented x, and then calculated the sum, while the
//        second configuration calculated the sum, and then incremented x.

        x = 5;
        y = 8;

        int sumVar = y + ++x;
        System.out.println(sumVar);

        x = 5;
        y = 8;
        int sumVar2 = y + x++;
        System.out.println(sumVar2);

    }
}
