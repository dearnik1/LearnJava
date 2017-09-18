package com.dearnik1.learnjava.basics;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		task4(5);
	}

	//Find the sum of the digits of an arbitrary integer.
	public static int task1(int number) {
		int a = 0;

		if (number < 0) {
			number = -number;
		}
		while(number > 0) {
			a += number % 10;
			number /= 10;
		}
		return a;
	}

	//Calculate the sum of the series 1! - 2! + 3! - 4! ... + n! for n > 0.
	public static long task2(int n) {
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				sum -= factorial(i);
			} else {
				sum += factorial(i);
			}
		}
		return sum;
	}

	private static long factorial(int num) {
		long res = 1;
		for (int i = 1; i <= num ; i++) {
			res *= i;
		}
		return res;
	}

	//Calculate how many six-digit numbers have an equal sum
	//of the first three and the last three digits.
	public static int task3() {
		int sum = 0;
		for (int i = 0; i <= 999999 ; i++){
			if (getSumOfDigitals(i % 1000) == getSumOfDigitals(i / 1000)) {
				sum++;
			}
		}
		return sum;
	}

	private static int getSumOfDigitals(int num) {
		int res = 0;
		for(int i = 0; i < 3; i++){
			res += num % 10;
			num /= 10;
		}
		return res;
	}


	//Use the 'for' loop to output (System.out.println()) numbers
	//in a geometric progression (1, 2, 4, 8, 16, 32).
	//The largest number must be less than 'n'.
	public static void task4(int n) {
		if (n < 1) {
			System.out.println("0");
			return;
		}
		for(long i = 1; i < n; i *= 2){
			System.out.println(i);
		}
	}


	//Read characters from System.in.read() stream and stop if you get '.' symbol.
	//Calculate how many spaces have been entered (use System.out.println() for output).
	//Replace all 'a' symbols with 'A' and print result String to System.out. 
	//Note: To convert a lowercase letter to a capital one,
	//you need to reduce its code by 32.
	public static void task5() throws IOException {
		char symbol;
		int sum = 0;
		String str = "";
		do {
			int data = System.in.read();
			if(data == -1) {
				break;
			}
			symbol = (char) data;
			if (symbol == 'a') {
				symbol -= 32;
			} else if (symbol == ' ') {
				sum++;
			}
			str += symbol;
		} while (symbol != '.');
		System.out.println(sum);
		System.out.println(str);
	}

}
