package boj_1253_좋다;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] nums;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (find(i)) answer++;
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	private static boolean find(int idx) {
		int num = nums[idx];
		int st = 0;
		int ed = 1;
		
		/*
		 * 반례:
		 * 11
		 * 0 1 2 3 4 5 6 7 8 9 10
		 * 
		 * ans: 8
		 * 
		 * 3을 찾으려면 1+2여야 하는데,
		 * 아래 식으로는 0+2일때 3보다 작아서 0이 1이 되기 전에 2가 3이 되어버리는 문제
		 */
		while (st < ed && ed < N) {
			if (nums[st]+nums[ed] == num && 
					st != idx && ed != idx) {
				return true;
			}
			else if (nums[st]+nums[ed] < num) ed++;
			else st++;
		}
		
		return false;
	}
}
