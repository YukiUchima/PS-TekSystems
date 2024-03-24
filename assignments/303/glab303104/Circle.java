package glab303104;

public class Circle extends Shape implements Movable {
    protected double radius;
    private int x, y; // coordinates of point
    private final double PI = Math.PI;

    //Provide moveable point
    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, double height) {
        this.radius = radius;
        super.height = height;

    }


    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public String getCoordinate() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public double getArea() {
        double area = PI * Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public void displayShapeName() {
        System.out.println("I am a Circle or radius: " + this.radius);
    }

    @Override
    public String toString() {
        return "Circle[radius=" + this.radius + super.toString() + "]";
    }
}
