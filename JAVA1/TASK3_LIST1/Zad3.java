package zad3;

import java.util.Random;

public class Zad3 {
	public static void main(String[] args) {
		Random gen = new Random();
		int[] arrayOfNumbers = new int[10];
		int n = Integer.parseInt(args[0]);
		
		for(int i=0; i<n; i++) {
			int one = gen.nextInt(10);
			arrayOfNumbers[i] = one;
			System.out.println(arrayOfNumbers[i]);
		}
		sumAll(arrayOfNumbers);
		mean(arrayOfNumbers);
	}
	
	public static void sumAll(int[] arr) {
		System.out.println("Suma");
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		System.out.println(result);
	}
	
	public static void mean(int[] arr) {
		System.out.println("srednia");
		double mean;
		double result = 0;
		for(int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		
		mean = result/arr.length;
		System.out.println(mean);
	}
}
