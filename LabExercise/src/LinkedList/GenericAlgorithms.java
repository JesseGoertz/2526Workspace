package LinkedList;

public class GenericAlgorithms {
    
    public static int getSumOfTwoLargest(int[] arr) throws Exception {
        if (arr.length == 2) {
            return arr[0] + arr[1];
        } else if (arr.length < 2) {
            throw new Exception();
        }
        int largest = arr[0];
        int second = arr[1];
        if (arr[1] > largest) {
            largest = arr[1];
            second = arr[0];
        }
        
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        
        return largest + second;
    }
    
    public static void main(String[] args) throws Exception {
        int arr1[] = {2, 1};
        int arr2[] = {2, 4, 6, 8, 10, 12}; 
        int arr3[] = {12, 10, 11};
        System.out.println(GenericAlgorithms.getSumOfTwoLargest(arr1));
        System.out.println(GenericAlgorithms.getSumOfTwoLargest(arr2));
        System.out.println(GenericAlgorithms.getSumOfTwoLargest(arr3));
    }

}
