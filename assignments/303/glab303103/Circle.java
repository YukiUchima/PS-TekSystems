package glab303103;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, double height) {
        this.radius = radius;
        super.height = height;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public void displayShapeName() {
        System.out.println("Drawing a circle of radius: " + this.radius);
    }

    @Override
    public String toString() {
        return "Circle[ radius = " + radius + super.toString() + "]";
    }

    public double getSurfaceArea() {
        return 2 * Math.PI * this.radius * (super.height + this.radius);
    }
}
