package boj_15649_N과M;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] nums;
	static boolean[] used;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		used = new boolean[N+1];

		comb(0);
		
		sc.close();

	}
	
	private static void comb(int cnt) {
		if (cnt >= M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if (!used[i]) {
				nums[cnt] = i;
				used[i] = true;
				comb(cnt+1);
				used[i] = false;
			}
			
		}
	}

}
