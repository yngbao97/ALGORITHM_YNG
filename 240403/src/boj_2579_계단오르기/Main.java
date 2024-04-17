package boj_2579_계단오르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] stairs = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
		}
		
		int[] dp = new int[N+1];
		for (int i = N-1; i > 1; i++) {
		}
		
		sc.close();
	}
}
