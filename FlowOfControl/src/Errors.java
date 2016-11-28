
public class Errors {
    
    void f() throws Exception {
        throw new Exception();
    }
    
    void foo() {
        System.out.println("starting foo");
        try {
            System.out.println("before f()");
            f();
            System.out.println("after f()");
        } catch (Exception e) {
            System.out.println("caught exception");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("After finally");
    }
    
    public static void main(String[] args) throws Exception {
        Errors error1 = new Errors();
        try {
            error1.foo();
        } finally {
            System.out.println("main finally");
        }
    }

}
