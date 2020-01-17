package com.nt.array;

import java.util.Scanner;

public class FindDuplicatFromArray {
	public static String getDuplicat(int[] arrNo) {
		StringBuilder sb = new StringBuilder();
		for (int no = 0; no <= arrNo.length - 1; no++) {
			for (int nextNo = no + 1; nextNo <= arrNo.length - 1; nextNo++) {
				if ((arrNo[no] == arrNo[nextNo]) && (!(no == nextNo))) {
					sb.append(arrNo[no]);
				}
			}
		}
		return "Duplicat numbers are::" + sb.toString();
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

		if (getDuplicat(arrInput).isEmpty()) {
			System.out.println("Duplicates are not found");
		} else
			System.out.println("Duplicat numbers are  " + getDuplicat(arrInput));
	}
}
