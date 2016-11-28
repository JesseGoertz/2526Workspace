
public class a2q4 {
    public static void main(String[] args) {
        int n = 50;
        int time = 88;
        for (int i = 1; i <= n; i++) {
            time += 2;
            for (int k = 1; k <= (i + 4); k++) {
                time += (12 * k);
            }
        }
        
        System.out.println("time = " + time);
    }
}
