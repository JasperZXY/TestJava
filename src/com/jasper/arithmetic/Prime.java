package com.jasper.arithmetic;

/**
 * 求出1~100之间的所有素数，用的是筛选法
 * @author Jasper
 */
public class Prime {
	private final static int N = 100;
	public static void main(String[] args) {
		int []primes = new int[N+1];
		for(int i=0; i<=N; i++) {
			primes[i] = 1;
		}
		for(int i=2; i<=N; i++) {
			if(primes[i] != 0) {
				for(int j=2*i; j<=N; j+=i) {
					primes[j] = 0;
				}
			}
		}
		for(int i=2; i<N; i++) {
			if(primes[i] == 1) {
				System.out.print(i + " ");
			}
		}
	}

}
