package boj_1676_팩토리얼0의개수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		
		long num = factorial(N);
		
		long rest = num % 10;
		num /= 10;
		int cnt = 0;
		
		while (num != 0 && rest == 0) {
			cnt++;
			rest = num % 10;
			num /= 10;
		}
		
		System.out.println(cnt);
		sc.close();
	}
	
	public static long factorial(long n) {
		if (n <= 1) return n;
		
		return n * factorial(n-1);
	}
}