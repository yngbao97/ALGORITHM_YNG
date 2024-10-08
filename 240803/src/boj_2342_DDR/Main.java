/*
 * [문제풀이]
 * 경우의 수 10가지와 밟아야 하는 각 지점을 기준으로 
 * 해당 지점부터 마지막 지점까지 들일 수 있는 최소의 힘을 저장해서 
 * 다른 상태에서 시작해 같은 상태에 도달 했을때의 중복탐색을 막았다.
 * 
 * 사실 왼발/오른발 구분이 의미가 없어서 더 효율적으로 탐색할 수 있지 않을까 싶다.
 */
package boj_2342_DDR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] power = {{0, 2, 2, 2, 2}, {0, 1, 3, 4, 3}, {0, 3, 1, 3, 4}, {0, 4, 3, 1, 3}, {0, 3, 4, 3, 1}};
	static int[] order;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		order = new int[input.length-1];
		for (int i = 0; i < order.length; i++) {
			order[i] = Integer.parseInt(input[i]);
		}
		
		dp = new int[5][5][order.length];
		
		int answer = dfs(0, 0, 0);
		
		System.out.println(answer);
		br.close();
	}

	private static int dfs(int left, int right, int idx) {
		
		if (idx >= order.length) return 0;
		
		if (dp[left][right][idx] != 0) return dp[left][right][idx];
		
		int next = order[idx];
		
		int a = (next <= right ? dfs(next, right, idx+1) : dfs(right, next, idx+1)) + power[left][next];
		int b = (left <= next ? dfs(left, next, idx+1) : dfs(next, left, idx+1)) + power[right][next];
		
		return dp[left][right][idx] = Math.min(a, b);
	}
}
