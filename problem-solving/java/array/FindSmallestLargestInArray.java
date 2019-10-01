package array;

import java.util.Arrays;

public class FindSmallestLargestInArray {

    public static void main(String[] args) {
        int [] arr = {4,2,3,8,0};
        // with use of library
        Arrays.sort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);

        //without any lib method
        int smallest = arr[0];
        int largest = arr[0];
        for(int num : arr){
            if(num > largest){
                largest = num;
            }
            if(num < smallest){
                smallest = num;
            }
        }
        System.out.println(smallest);
        System.out.println(largest);
    }
}
