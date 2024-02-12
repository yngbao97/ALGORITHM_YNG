package 블랙잭_2798_240212;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int limit = sc.nextInt();
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = nums[i]+nums[j]+nums[k];
					if (sum <= limit && sum > max) max = sum;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}
