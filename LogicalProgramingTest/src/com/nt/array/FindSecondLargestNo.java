package com.nt.array;

import java.util.Scanner;

public class FindSecondLargestNo {

	public static String getSecondLargestNo(int[] arrNo) {
		StringBuilder sb = new StringBuilder();
		if(arrNo.length==0 || arrNo.length==1) {
			return "No duplicate detect in array ";
		}
		for (int i = 0; i <= arrNo.length - 1; i++) {
			for (int j = 0; j < arrNo.length - 1 - 1; j++) {
				if (arrNo[j] > arrNo[j++]) {
					int temp = arrNo[j];
					arrNo[j] = arrNo[j++];
					arrNo[j++] = temp;
				}
				if(i==2) {
					break;
				}
			}
		}
		return ""+arrNo[arrNo.length-2];
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
		System.out.println("Sesond largest no is::" + getSecondLargestNo(arrInput));
	}
}
