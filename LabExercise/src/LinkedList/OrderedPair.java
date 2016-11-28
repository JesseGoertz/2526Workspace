package ca.bcit.comp2526.lab;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderedPair<K, V> {
    
    private K first;
    private V second;
    
    public OrderedPair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
    
    public static <K, V> boolean equivalent(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getFirst().equals(p2.getFirst()) && p1.getSecond().equals(p2.getSecond());
    }
    
    // Convert into generic for any class that implements Comparable interface
    // Test it using array of Integer and array of String
    public static int min(int[] data) {
        int result = data[0];
        for (int value : data) {
            if (result > value)
                result = value;
        }
        return result;
    }
    
    public static <T extends Comparable<T>> T min(T[] data) {
        T result = data[0];
        for (T value : data) {
            if (result.compareTo(value) > 0)
                result = value;
        }
        return result;
    }
    
    public static void main(String[] args) {
        OrderedPair<String, String> pair = new OrderedPair<>("test", "test2");
        ArrayList<Integer> list = new ArrayList<Integer>();
        OrderedPair<ArrayList<Integer>, Integer> pair2 = new OrderedPair<>(list, 10);
        Box<Double> b1 = new Box<>();
        Box<Double> b2 = new Box<>();
        OrderedPair<Box<Double>, Box<Double>> pair3 = new OrderedPair<>(b1, b2);
        
        OrderedPair<Integer, Integer> p1 = new OrderedPair<>(10, 5);
        OrderedPair<Integer, Integer> p2 = new OrderedPair<>(10, 5);
        OrderedPair<Integer, Integer> p3 = new OrderedPair<>(10, 9);
        
        System.out.println(equivalent(p1, p2));
        System.out.println(equivalent(p1, p3));
        System.out.println(OrderedPair.<Integer, Integer>equivalent(p1, p2));
        // Above forces a precondition of comparing OrderedPairs of Integer, Integer
        
        Integer[] arr1 = {10, 12, 6, 5, 8};
        String[] arr2 = {"Hello", "World", "How", "Are", "You"};
        System.out.println(OrderedPair.min(arr1));
        System.out.println(OrderedPair.min(arr2));
        
        // Fastest search algorithm for ordered array? binary sort
        
        /**
         * qsort:
         * 
         * Element = 5
         * 
         * 5 7 9 13 2 4 6
         * 4 7 9 13 2 5 6
         * 4 5 9 13 2 7 6
         * 4 2 9 13 5 7 6
         * 4 2 5 13 9 7 6
         * 
         * {4, 2}
         * Element = 4
         * 4 2
         * 2 4
         * 
         * {13, 9, 7, 6}
         * Element = 13
         * 13 9 7 6
         * 6 9 7 13
         * 
         * {6, 9, 7}
         * Element = 6
         * 6 9 7
         * 
         * {9, 7}
         * Element = 9
         * 9 7
         * 7 9
         * 
         * {2, 4, 5, 6, 7, 9, 13}
         */
        
        // Big O complexity of a bubble sort is O(n^2)
        
    }
    
}
