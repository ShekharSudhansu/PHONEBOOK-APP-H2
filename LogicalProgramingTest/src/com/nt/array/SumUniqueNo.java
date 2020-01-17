package com.nt.array;

import java.util.Scanner;

public class SumUniqueNo {
	
	public static String sumOfUniqueNumber(int[] arrNo) {
		int sum=0;
		for(int no=0;no<=arrNo.length-1;no++) {
			for(int nextNo=no+1;nextNo<=arrNo.length-1;nextNo++) {
				if(!(arrNo[no]==arrNo[nextNo])) {
					sum=sum+arrNo[nextNo];
				}
				 
			}
		}
			return ""+sum;
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
			System.out.println(""+sumOfUniqueNumber(arrInput));
		}
}
