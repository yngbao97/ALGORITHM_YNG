package boj_1978_소수찾기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] > max) max = nums[i];
		}
		
		boolean[] not_Prime = new boolean[max+1];
		not_Prime[0] = true;
		not_Prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (!not_Prime[i]) {
				for (int j = i+1; j <= max; j++) {
					if (j%i == 0 && !not_Prime[j]) {
						not_Prime[j] = true;
					}
				}
			}
		}
		
		int answer = 0;
		for (int num : nums) {
			if (!not_Prime[num]) {
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}
