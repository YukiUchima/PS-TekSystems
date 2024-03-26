package glab303102;

import org.w3c.dom.css.Rect;

public class App {

    public static void main(String[] args) {
        Circle c = new Circle(100);
        System.out.printf("Area of Circle %.2f%n", c.getArea());

        // Example of Object type casting
        // declaration of object variable obj of the Shape class

        // Shape sObj ; // object creation of the Shape class
        Shape sObj = new Shape();
        sObj.displayshapeName();
        System.out.println(sObj instanceof Shape); // true


        // object creation of the Circle class
        System.out.println("+++++++++");

        // it’s fine because a Circle is a Shape by inheritance
        Shape shapeCircleObj = new Circle(100);  // UpCasting
        shapeCircleObj.displayshapeName();
        System.out.printf("Area of Circle %.2f%n", shapeCircleObj.getArea());
        System.out.println(shapeCircleObj);  // Run circle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeCircleObj instanceof Circle); // true
        System.out.println(sObj instanceof Circle); // false because Shape is not a Circle

        System.out.println("--------------------");
        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
        shapeRectangleObj.displayshapeName();
        shapeRectangleObj.setHeight(2);
        shapeRectangleObj.setWidth(2);
        System.out.printf("Area of Rectangle is %.2f%n", shapeRectangleObj.getArea());
        System.out.println(shapeRectangleObj);  // Run Rectangle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeRectangleObj instanceof Rectangle); // true
        System.out.println(sObj instanceof Rectangle); // false because Shape is not a Rectangle

        System.out.println("--------------------");
        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
        shapeTriangleObj.displayshapeName();
        shapeTriangleObj.setHeight(2);
        shapeTriangleObj.setBase(3);
        System.out.printf("Area of Triangle is %.2f%n", shapeTriangleObj.getArea());
        System.out.println(shapeTriangleObj);  // Run Triangle's toString()

        // Use instanceof operator for Validation
        System.out.println(shapeTriangleObj instanceof Triangle); // true
        System.out.println(sObj instanceof Triangle); // false because Shape is not a Triangle
        System.out.println("--------------------");

        Cylinder cylinderShape = new Cylinder(3); //UpCasting
        cylinderShape.displayshapeName();
        cylinderShape.setHeight(3);
        System.out.printf("Area of Cylinder is %.2f%n", cylinderShape.getVolume());
        System.out.println(cylinderShape);  // Run cylinderShape's toString()




    }
}
