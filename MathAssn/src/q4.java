
public class q4 {

    public static void main(String[] args) {

        int n = 50;
        int counter = n;
        
        for (int i = 2; i <= (n+5); i++) {
            counter += 10;
            
            for (int j = i + 1; j <= (n+5); j++) {
                counter += 20;
            }
        }
        
        System.out.println(counter);

    }

}
