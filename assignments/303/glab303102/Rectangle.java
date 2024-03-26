package glab303102;

public class Rectangle extends Shape {
    public Rectangle(String color){
        super(color);
    }

    public Rectangle(){

    }

    public Rectangle(String color, double area, double width, double base, double height){
        super(color, area, base, width, height);
    }

    @Override
    public void setBase(double base){
        super.base = base;
    }

    @Override
    public void setWidth(double width){
        super.width = width;
    }

    @Override
    public double getArea(){
        return width * height;
    }

    public double perimeter(){
        return 2 * (width + height);
    }

    @Override
    public void displayshapeName(){
        System.out.println("I am a rectangle");
    }

    @Override
    public String toString(){
        return "Rectangle[height= " + height + " " + "width= " + width +  super.toString() + "]";
    }
}
