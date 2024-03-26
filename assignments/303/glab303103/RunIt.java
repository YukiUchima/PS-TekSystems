package glab303103;

public class RunIt {

    public static void main(String[] args) {
        Circle c = new Circle(100);
        System.out.printf("Area of Circle %.2f%n", c.getArea());

        // Shape sObj = new Shape(); // This will give Error, we can not instantiate Abstract class

        // object creation of the Circle class
        System.out.println("+++++++++++++++++");
        // it’s fine because a Circle is a Shape by inheritance
        Shape shapeCircleObj = new Circle(100);  // UpCasting
        shapeCircleObj.displayShapeName();
        System.out.printf("Area of Circle %.2f%n", shapeCircleObj.getArea());
        System.out.println(shapeCircleObj);  // Run circle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeCircleObj instanceof Circle); // true

        System.out.println("+++++++++++++++++");
        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
        shapeRectangleObj.displayShapeName();
        shapeRectangleObj.setHeight(2);
        shapeRectangleObj.setWidth(4);
        System.out.printf("Area of Rectangle is %.2f%n", shapeRectangleObj.getArea());
        System.out.println(shapeRectangleObj);  // Run Rectangle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeRectangleObj instanceof Rectangle); // true
        System.out.println("--------------------");
        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
        shapeTriangleObj.displayShapeName();
        shapeTriangleObj.setHeight(10);
        shapeTriangleObj.setBase(15);
        System.out.printf("Area of Triangle is %.2f%n", shapeTriangleObj.getArea());
        System.out.println(shapeTriangleObj);  // Run Triangle's toString()


    }
}
