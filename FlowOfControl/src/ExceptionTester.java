
public class ExceptionTester {
    
    public ExceptionTester() {
        
    }
    
    public void firstMethod() {
        try {
            System.out.println("starting 1st method");
            System.out.println("calling 2nd method");
            secondMethod();
            System.out.println("returned from 2nd");
        } catch (Exception e) {
            System.out.println("1st method caught exception");
        } finally {
            System.out.println("1st method finally");
        }
    }
    
    public void secondMethod() {
        try {
            System.out.println("starting 2nd method");
            System.out.println("calling 3rd method");
            thirdMethod();
            System.out.println("returned from 3rd method");
        } catch (Exception e) {
            System.out.println("2nd method caught exception");
        } finally {
            System.out.println("2nd method finally");
        }
    }
    
    public void thirdMethod() throws NotYetImplementedException {
        System.out.println("starting 3rd method");
        throw new NotYetImplementedException();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExceptionTester test = new ExceptionTester();
        test.firstMethod();
    }

}
