package com.jasper.arithmetic.sort;

public class QuickSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		while(left < right) {
			while(left < right && arr[right] >= pivot)
				right --;
			swap(arr, left, right);
			while(left < right && arr[left] <= pivot)
				left ++;
			swap(arr, left, right);
		}
		return right;
	}
	
	private static void sort(int []arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot-1);
			sort(arr, pivot+1, right);
		}
	}
	
	private static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 12, 4, 1, 10, 3, 8, 20, 5, 7};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
