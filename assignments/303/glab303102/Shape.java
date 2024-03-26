package glab303102;

public class Shape {

    private String color;
    protected double area = 1.0;
    protected double base = 1.0;
    protected double width = 1.0;
    protected double height = 1.0;

    public Shape(String color){
        this.color = color;
    }

    public Shape(){}

    public Shape(String color, double area, double base, double width, double height){
        this.color = color;
        this.area = area;
        this.base = base;
        this.width = width;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
//        Subclass must override this method
        System.out.println("Shape is unknown, cannot compute area");
        return 0;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString(){
        return "Shape[color="+ color + "]";
    }

    public void displayshapeName(){
        System.out.println("I am a shape.");
    }
}
