/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */

package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	
	// Array Solution
	
    public String largestNumber(final int[] A) {
        String[] arr = new String[A.length];
        for(int i = 0; i < A.length; i++){
            arr[i] = Integer.toString(A[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String x, String y){
                return (y+x).compareTo(x+y);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
        while(sb.charAt(0)=='0'&&sb.length()>1){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
    
    // ArrayList Solution
    
    public String largestNumber(final List<Integer> A) {
        String[] arr = new String[A.size()];
        for(int i = 0; i < A.size(); i++){
            arr[i] = Integer.toString(A.get(i));
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String x, String y){
                return (y+x).compareTo(x+y);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
    }

}
