package p1;

class Father {   
    
    public void talk() {
        System.out.println("Manners");
    }
}

class Son extends Father {
    public final void talk() {
        super.talk();
    }
}

public class SuperTest {
    Son s = new Son();
    s.talk();
}
