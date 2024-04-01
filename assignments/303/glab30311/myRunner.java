package glab30311;

public class myRunner {

    public static void main(String[] args) {
        DemoClass runIt = new DemoClass();

        runIt.genericsMethod("String type");
        runIt.genericsMethod(123);
        runIt.genericsMethod(321.12);
        runIt.genericsMethod('H');

        GMultipleDataType<String, Integer> newObj = new GMultipleDataType<>("Lets goo!", 777);

        System.out.println(newObj.getValueOne());
        System.out.println(newObj.getValueTwo());

        GMultipleDataType<String, String> newStringObj = new GMultipleDataType<>("Red Hot Chili", "Peppers!");

        System.out.println(newStringObj.getValueOne());
        System.out.println(newStringObj.getValueTwo());
    }
}