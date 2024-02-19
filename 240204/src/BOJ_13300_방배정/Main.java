package BOJ_13300_방배정;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = sc.nextInt();
		int[][] students = new int [2][7];
		
		for (int i = 0; i < N; i++) {
			students[sc.nextInt()][sc.nextInt()]++;
		}
		
		int answer = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (students[i][j] % max == 0) {
					answer += students[i][j] / max;
				} else answer += (students[i][j] / max) + 1;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}