package com.jasper.mine;

public class ArrayReverse {
	public static void main(String[] args) {
		int[] arr = new int[11];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		reverse(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		
	}
	
	public static void reverse(int[] arr) {
		if(arr != null && arr.length > 1) {
			for(int i=0,j=arr.length-1; i<j; i++,j--) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
	}

}
