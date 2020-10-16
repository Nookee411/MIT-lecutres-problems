package peakFinding.oneDimentional;

import java.util.*;

public class PeakFinding1D {
    public static void main(String[] args) {
        var array = new LinkedList<Double>();
        var rand = new Random();
        var size = 10000;
        for(double i = 0d; i<size; i++) array.add(i);
        array.add(1d);

        //Trivial method
        long start =System.currentTimeMillis();
        System.out.println("Trivial: " + FindPeekTrivial(array));
        long end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
        start = System.currentTimeMillis();
        System.out.println("D&C: " + FindPeakDivAndConquer(array));
        end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
    }

    private static int FindPeakDivAndConquer(LinkedList<Double> array){
        //The idea is that We use some kind of binary search
        //We watch at mid element of array. If it is less than previous - we look through left side
        //if it is less than right element- we look to the right side
        //O(log n)
        return FindPeak(array,0,array.size());
    }

    private static int FindPeak(LinkedList<Double> array,int low,int high){
        int mid = (high+low)/2; //Finding midpoint
        if(array.get(mid)<array.get(Math.max(mid-1,0))) //function is decreasing at mid place
            return FindPeak(array,low, mid-1);
        else if(array.get(mid)<array.get((mid+1)%array.size())) //function is increasing at mid place
            return FindPeak(array,mid+1,high);
        else //peak found
            return mid;
    }

    private static int FindPeekTrivial(LinkedList<Double> array){
        //Trivial method for peak finding
        //go through entire array and check every element
        //O(n)
        if(array.get(0)>=array.get(1))
            return 0;
        if(array.get(array.size()-1)>array.get(array.size()-2))
            return array.size()-1;
        for (int i = 1; i < array.size()-1; i++) {
            var curValue = array.get(i);
            if(array.get(i-1)<=curValue&&
                curValue>=array.get(i+1))
                return i;
        }
        return -1;
    }

    private static int max(int a, int b){
        return a>b?a:b;
    }
}
