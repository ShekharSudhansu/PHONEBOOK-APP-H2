package com.nt.array;

import java.util.Scanner;

public class FindMaxDiff {
	
	
	public static String getMaxDiff(int[] arr) {
		for(int i=0;i<=arr.length-1;i++) {
			for(int j=0;j<=arr.length-1-1;j++) {
				if(arr[j]>arr[j++]) {
				int temp=arr[i];
				arr[i]=arr[j++];
				arr[j++]=temp;
				}
			}
		}
		return "The max difference is:"+(arr[arr.length-1]-arr[0]);
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many number you want ?");
		int no = sc.nextInt();
		int[] arrInput = new int[no];

		for (int i = 0; i <= arrInput.length - 1; i++) {
			System.out.println("Enter no::");
			arrInput[i] = sc.nextInt();
		}
		 System.out.println(getMaxDiff(arrInput));
	}
}
