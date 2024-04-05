package Exercise30314;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            try {
                checkMath(input);
                end = true;
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println(e);
                System.out.println("Try again...");
            }
        }
        System.out.println("\nEnd of program...");
        input.close();


//        --------------------------TEST
//        System.out.println(MathCalculation.valueOf(2));


    }

    private static void checkMath(Scanner scanner) throws NumberFormatException, ArithmeticException {
        System.out.println("Please enter series of numbers, only TWO for division:");
        String[] strArray = scanner.nextLine().strip().split("\s+");
        Integer[] intArr = new Integer[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            intArr[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println(Arrays.toString(intArr));
        System.out.println("Indicate which operation to perform:\n" +
                "\t(1)ADD     \n\t(2)SUBTRACT    \n\t(3)MULTIPLY   \n\t(4)DIVIDE");

        int calcMethod = scanner.nextInt();
        scanner.nextLine();

        MathCalculation option = MathCalculation.valueOf(calcMethod);
        MainEntry calculator = new MainEntry();

        switch (option) {
            case ADD -> System.out.println(calculator.adder.compute(intArr));
            case SUBTRACT -> System.out.println(calculator.difference.compute(intArr));
            case MULTIPLY -> System.out.println(calculator.multiply.compute(intArr));
            case DIVIDE -> {
//                Attempting to convert array to double
//                Double[] dArr = Arrays.stream(intArr).map(Double.class::cast).toArray(Double[]::new);
                System.out.println(calculator.division.compute(intArr));
            }
            default -> System.out.println("DEFAULT");
        }
    }


    private enum MathCalculation {

        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

        private final int calcType;

        MathCalculation(int calcType) {
            this.calcType = calcType;
        }

        public static final Map<Integer, MathCalculation> OPTION_NUM = new HashMap<>();

        static {
            for (MathCalculation calcOption : values()) {
                OPTION_NUM.put(calcOption.calcType, calcOption);
            }
        }

        public static MathCalculation valueOf(int value) {
            return OPTION_NUM.get(value);
        }
    }
}