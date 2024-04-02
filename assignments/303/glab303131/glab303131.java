package glab303131;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Guided Lab - 303.13.1 - Reading a Delimited File
public class glab303131 {

    public static void main(String[] args) {
//    exampleOne();
        exampleTwo();


    }

    private static void exampleOne() {
//        Example 1
        try {
            String filePath = "C://Users//admin//Documents//gitHub//PS-TekSystems//projects//PracticeAssignments" +
                    "//src//glab303131//cars.csv";
            File file =
                    new File(filePath);
            Scanner readFile = new Scanner(file);
            ArrayList<String[]> data = new ArrayList<>();
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] splitLine = line.split(",");
                data.add(splitLine);
            }

            int maxWidth = findMaxWidth(data);
            for (String[] line : data) {
                for (String col : line) {
                    System.out.printf("%-" + maxWidth + "s", col);
                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...: " + e.getMessage());
        }
    }

    private static void exampleTwo() {
//        Example 2
//        Let’s make our code more professional using the concept of “Encapsulation.”
        String filePath = "C://Users//admin//Documents//gitHub//PS-TekSystems//projects//PracticeAssignments" +
                "//src//glab303131//CourseData.csv";

        try {
            File file = new File(filePath);
            Scanner readFile = new Scanner(file);
            ArrayList<course> data = new ArrayList<>();

            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] splitLine = line.split(",");

                course courseObj = new course();
                courseObj.setCode(splitLine[0]);
                courseObj.setCourse_name(splitLine[1]);
                courseObj.setInstructor_name(splitLine[2]);

                data.add(courseObj);

            }
            int codeWidth = -12;
            int courseNameWidth = -30;
            int instructorNameWidth = 20;
            Boolean runOnce = true;
            for (course line : data) {
                System.out.printf("%"+codeWidth+"s | %"+courseNameWidth+"s | %"+instructorNameWidth+"s\n", line.getCode(), line.getCourse_name(), line.getInstructor_name());
                if(runOnce){
                    int fullwidth = Math.abs(codeWidth + courseNameWidth) + instructorNameWidth;
                    for (int i = fullwidth; i > -6; i--) {
                        System.out.printf("=");
                    }
                    System.out.println();
                    runOnce = false;
                }
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static int findMaxWidth(ArrayList<String[]> data) {
        int max = 0;
        for (String[] line : data) {
            for (String word : line) {
                if (max < word.length()) {
                    max = word.length();
                }
            }
        }
        return max;
    }
}
