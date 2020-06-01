/*
You are given an array A containing N integers. The special product of each ith integer in this array is defined as
the product of the following:

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j] s are
present in multiple positions, the LeftSpecialValue is the maximum value of j.

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are
present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.
Input: You will receive array of integers as argument to function.
Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9 
 */

package arrays;

import java.util.ArrayList;
import java.util.Stack;

public class MaxSpecialProduct {
	
	// ArrayList solution
	
    public ArrayList<Integer> lsvList(ArrayList<Integer> A) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = 0; i < A.size(); i++){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)) {
                s.pop();
            }
            if(s.empty()) {
                l.add(0);
            } else {
                l.add(s.peek());
            }
            s.push(i);
        }
        
        return l;
    }
    
    public ArrayList<Integer> rsvList(ArrayList<Integer> A) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = A.size()-1; i >= 0; i--) {
            while(!s.empty() && A.get(s.peek()) <= A.get(i)) {
                s.pop();
            }
            if(s.empty()) {
                r.add(0, 0);
            } else {
                r.add(0, s.peek());
            }
            s.push(i);
        }
        
        return r;
    }
    public int maxSpecialProduct(ArrayList<Integer> A) {
        ArrayList<Integer> l = lsvList(A);
        ArrayList<Integer> r = rsvList(A);
        
        long res = 0, product;
        
        for(int i = 0; i < A.size(); i++) {
            product = (long)l.get(i)*(long)r.get(i);
            if(res < product) {
                res = product;
            }
        }
        
        return (int)(res%1000000007);
    }

}
