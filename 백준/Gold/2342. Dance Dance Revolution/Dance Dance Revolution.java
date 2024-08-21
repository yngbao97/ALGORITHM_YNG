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
		int min = Math.min(dfs(next, right, idx+1) + power[left][next], 
							dfs(left, next, idx+1) + power[right][next]);
		
		return dp[left][right][idx] = min;
	}

}