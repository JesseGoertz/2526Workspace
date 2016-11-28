package p1;

abstract class Shape {
    public Shape() {
        System.out.println("instantiating shape");
        draw();
        System.out.println("Finished drawing shape");
    }
    
    void draw() {
        System.out.println("drawing shape");
    }
}

public class Circle extends Shape {
    private int radius = 1;
    
    Circle(int rad) {
        radius = rad;
        System.out.println("Circle has radius = " + radius);
    }
    
    void draw() {
        System.out.println("Drawing circle radius = " + radius);
    }
    
    public static void main(String[] args) {
        Circle orbit = new Circle(5);
    }
}
