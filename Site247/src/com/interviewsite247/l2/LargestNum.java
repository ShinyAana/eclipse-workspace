package com.interviewsite247.l2;
import java.util.Scanner;
public class LargestNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(),nums[]=new int[n],largest_number=-100,flag=0,large_index=-1;
        for(int i=0;i<n;i++) {
            nums[i]=input.nextInt();
            if(nums[i]>largest_number) {
                largest_number=nums[i];
                large_index=i;
            }
        }
        for(int i=0;i<n;i++) {
           if(i!=large_index) {
               if(nums[i]*2>largest_number) {
                   flag=1;
               }
           }
        }
        if(flag==1) {
            System.out.println("-1");
        }
        else {
            System.out.println(large_index);
        }
    }
}

