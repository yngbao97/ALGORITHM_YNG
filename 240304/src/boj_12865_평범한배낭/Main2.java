package boj_12865_평범한배낭;

import java.util.Scanner;

public class Main2 {

	static int N;
	static int K;
	static int[][] items;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		items = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			items[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		comb(0, 0, 0);

		System.out.println(answer);
		sc.close();
	}
	
	private static void comb(int idx, int weight, int value) {
		if (weight > K) return;
		
		if (idx >= N) {
			answer = Math.max(answer, value);
			return;
		}
		
		comb(idx+1, weight+items[idx][0], value+items[idx][1]);
		comb(idx+1, weight, value);
	}
}
