/*
 * 각각 2, 3으로 나누어 떨어지는 경우만 확인했는데, 6으로 나누어 떨어지는 경우도 다시 고려해야 했다.
 * 그리고 각각의 경우를 판단할 때 어디가 가장 최소연산인지 모르니까 if else가 아니라 if만으로 조건을 확인한다.
 * 
 */
package boj_1463_1로만들기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			int minCnt = dp[i-1]+1;
			if (i % 6 == 0) {
				minCnt = Math.min(minCnt, dp[i/6]+2);
			}
			if (i % 3 == 0) {
				minCnt = Math.min(minCnt, dp[i/3]+1);
			}
			if (i % 2 == 0) {
				minCnt = Math.min(minCnt, dp[i/2]+1);
			}
			dp[i] = minCnt;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
