package p1;

class Alpha {
    
    protected void foo() {
        System.out.println("Alpha");
    }
}

public class Visibility extends Alpha {
    
    public void foo() {
        System.out.println("Beta");
    }

}
