
public class Series {
    
    public static int positiveLinearSeriesSum(int upperBound) throws IllegalArgumentException {
        if (upperBound < 0) {
            throw new IllegalArgumentException();
        }
        
        int total = 0;
        for (int i = 0; i <= upperBound; i++) {
            total += i;
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        System.out.println(Series.positiveLinearSeriesSum(5));
        System.out.println(Series.positiveLinearSeriesSum(432));
    }

}
