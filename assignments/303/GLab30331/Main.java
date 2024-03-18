package glab30331;
//Guided LAB 303.3.1 - Java String Methods

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//      1.)
        lengthDemo();

//      2.)
        isEmptyDemo();

//      3.)
        trimDemo();

//      4.)
        lowerCaseDemo();
        
//        5.)
        toUpperDemo();

//        6.)
        concatDemo();
        
//        7.)
        splitDemo();

//        8.)
        charAtDemo();

//        9.)
        compareDemo();

//        10.)
        substringDemo();

//        11.)
        indexOfDemo();
        
//        12.)
        containsDemo();
        
//        13.)
        replaceDemo();

//        14.)
        replaceAllDemo();

//        15 && 16
        equalsDemo();

//        17.)
        equalsOperatorDemo();

//        18.)
        compareToDemo();

    }

    private static void compareToDemo() {
        String s1="Perscholas";
        String s2="Perscholas";
        String s3="Perschola";
        String s4="PerscholasX";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
    }

    private static void equalsOperatorDemo() {
        String s1="Perscholas";
        String s2="Perscholas";
        String s3=new String("Perscholas");
        System.out.println(s1==s2);
        System.out.println(s1==s3);

    }

    private static void equalsDemo() {
        String s1="PerScholas";
        String s2="PerScholas";
        String s3=new String("PerScholas");
        String s4="Teksystem";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//false

    }

    private static void replaceAllDemo() {
        String str1 = "Java123is456fun";

        // regex for sequence of digits
        String regex = "\\d+";

        // replace all occurrences of numeric
        // digits by a space
        System.out.println(str1.replaceAll(regex, " "));
s
    }

    private static void replaceDemo() {
        String str1 = "abc cba";

        // all occurrences of 'a' is replaced with 'z'
        System.out.println(str1.replace('a', 'z'));

        // all occurences of 'L' is replaced with 'J'
        System.out.println("Lava".replace('L', 'J'));
        // character not in the string
        System.out.println("Hello".replace('4', 'J'));
// all occurrences of "C++" is replaced with "Java"
        System.out.println(str1.replace("C++", "Java"));

        // all occurences of "aa" is replaced with "zz"
        System.out.println("aa bb aa zz".replace("aa", "zz"));

        // substring not in the string
        System.out.println("Java".replace("C++", "C"));

    }

    private static void containsDemo() {
        String str1 = "Learn Java";
        Boolean result;

        // check if str1 contains "Java"
        result = str1.contains("Java");
        System.out.println(result);  // true

        // check if str1 contains "Python"
        result = str1.contains("Python");
        System.out.println(result);  // false

        // check if str1 contains ""
        result = str1.contains("");

        System.out.println(result);  // true

    }

    private static void indexOfDemo() {
        String str1 = "Java is fun";
        int result;

        // getting index of character 's'
        result = str1.indexOf('s');

        System.out.println(result); // 6

        // getting index of character 'J'
        result = str1.lastIndexOf('J');
        System.out.println(result);

        // the last occurrence of 'a' is returned
        result = str1.lastIndexOf('a');
        System.out.println(result); // 3

        // character not in the string
        result = str1.lastIndexOf('j');
        System.out.println(result); // -1

        // getting the last occurrence of "ava"
        result = str1.lastIndexOf("ava");
        System.out.println(result); // 1

        // substring not in the string
        result = str1.lastIndexOf("java");
        System.out.println(result); // -1


    }


    private static void substringDemo() {
        String str1 = "java is fun";

        // extract substring from index 0 to 3
        System.out.println(str1.substring(0, 4));

    }

    private static void compareDemo() {
        String s1="hello";
        String s2="hello";
        String s3="hemlo";
        String s4="flag";
        System.out.println(s1.compareTo(s2));
    }

    private static void charAtDemo() {
        String message = "Welcome to Java";
        System.out.println("The first character in the message is " + message.charAt(0));
    }

    private static void splitDemo() {
        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));

    }

    private static void toUpperDemo() {
        String s1="hello how are you";
        String s1upper=s1.toUpperCase();
        System.out.println(s1upper);
    }

    private static void lowerCaseDemo() {
        String s1="HELLO HOW Are You?";
        String s1lower=s1.toLowerCase();
        System.out.println(s1lower);
    }

    private static void trimDemo() {
        String s1="  hello   ";
        System.out.println(s1+"how are you");        // without trim()
        System.out.println(s1.trim()+"how are you"); // with trim()
    }

    private static void isEmptyDemo() {
        String s1="";
        String s2="hello";
        System.out.println(s1.isEmpty());      // true
        System.out.println(s2.isEmpty());
    }

    static void concatDemo(){
        String message = "Welcome to Java";
        System.out.println("The first character in the message is " + message.charAt(0));

        //------By using concat method----
        String str1 = "Learn ";
        String str2 = "Java";
        // concatenate str1 and str2
        System.out.println(str1.concat(str2)); // "Learn Java"

        // concatenate str2 and str11
        System.out.println(str2.concat(str1)); // "JavaLearn "
        //--- By using + operator---
        String s3 =  "hello";
        String s4 = "Learners";
        //  String s5 = s3.concat(s4); or
        String s5 = s3 + s4;
        //both of the above statement will give you the same result

        // Three strings are concatenated
//        String message = "Welcome " + "to " + "Java";

        // String Chapter is concatenated with number 2
        String s = "Chapter" + 2; // s becomes Chapter2

        // String Supplement is concatenated with character B
        String s1 = "Supplement" + 'B'; // s1 becomes SupplementB

    }

    static void lengthDemo(){
        String str1 = "Java";
        String str2 = "";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println("Java".length());  // 4
        System.out.println("Java\n".length()); // 5
        System.out.println("Learn Java".length()); // 10
    }
}
