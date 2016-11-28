import java.lang.reflect.Array;

public class Recursive {
    
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return factorial(num - 1);
        }
    }
    
    public static int positiveLinearSeriesSum(int upperBound) throws IllegalArgumentException {
        if (upperBound < 0) {
            throw new IllegalArgumentException();
        }
        if (upperBound == 0) {
            return 0;
        } else {
            return upperBound + positiveLinearSeriesSum(upperBound - 1);
        }
    }
    
    public static void drawTriangle(int height) throws IllegalArgumentException {
        if (height < 1) {
            throw new IllegalArgumentException();
        }
        if (height > 1) {
            for (int i = 0; i < height; i++) {
                System.out.print("*");
            }
            System.out.println();
            drawTriangle(height - 1);
        } else {
            System.out.println("*");
        }
        
    }
    
    public static String reverseString(String arg) {
        if (arg.length() == 0) {
            return arg;
        } else {
            //reverseString()
            char firstChar = arg.charAt(0);
            String newString = arg.substring(1);
            return reverseString(newString) + firstChar; 
        }
    }
    
    public static int sumInt(int n) {
        if (n < 10) {
            return n;
        }
        
        int remainder = n % 10;
        int newNum = n / 10;
        
        return remainder + sumInt(newNum);
    }
    
    public static int[] reverseArr(int[] n) {
        int length = Array.getLength(n);
        if (length == 0) {
            return n;
        } else {
            int[] subArr = new int[length - 1];
            int firstInt = n[0];
            for (int i = 0; i < length - 1; i++) {
                subArr[i] = n[i + 1];
            }
            subArr = reverseArr(subArr);
            int[] newArr = new int[length];
            for (int j = 0; j < length - 1; j++) {
                newArr[j] = subArr[j];
            }
            newArr[length - 1] = firstInt;
            return newArr;
        }
    }
    
    public static void main(String[] args) {
        
        //Recursive.drawTriangle(5);
        //Recursive.factorial(100000);
        //System.out.println(Recursive.sumInt(123));
        int[] intArray = {1, 2, 3, 4, 5};
        intArray = reverseArr(intArray);
        for (int i = 0; i < Array.getLength(intArray); i++) {
            System.out.print("" + intArray[i] + " ");
        }
        //System.out.println(Recursive.reverseString("Hello"));
        
        
    }

}
