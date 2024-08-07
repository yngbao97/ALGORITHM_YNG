package boj_11053_가장긴증가하는부분수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
		}
		
		int answer = 1;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					answer = Math.max(answer, dp[i]);
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}