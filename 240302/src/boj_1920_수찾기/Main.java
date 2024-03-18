package boj_1920_수찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] nums;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		nums = new int[N];
		
		for (int i = 1; i < N; i++) {
			nums[i] = sc.nextInt();	
		}
		
		Arrays.sort(nums);
		
		int M = sc.nextInt();
		int[] answers = new int[M];
		for (int i = 0; i < M; i++) {
			int tmp = sc.nextInt();
			if (binarySearch(tmp) >= 0) {
				
			}
		}
		
		for (int answer : answers) {
			System.out.println(answer);
		}
		sc.close();
	}

	public static int binarySearch(int tmp) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = (left+right) / 2;
			
			if (tmp > nums[mid]) {
				left = mid+1;
			} else if (tmp < nums[mid]) {
				right = mid-1;
			} else if (tmp == nums[mid]) {
				return 1;
			}
		}
		return 0;
	}

	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}