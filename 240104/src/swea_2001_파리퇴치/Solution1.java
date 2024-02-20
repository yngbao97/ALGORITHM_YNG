package swea_2001_파리퇴치;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 원본 배열 생성
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			// 누적합 배열 생성
			int[][] prefixSum = new int[N+1][N+1];
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					prefixSum[r][c] = prefixSum[r-1][c] + prefixSum[r][c-1] 
							- prefixSum[r-1][c-1] + arr[r-1][c-1];
				}
			}
			
			// 범위 합 계산 및 최대값 비교
			int max = 0;
			for (int r = 1; r <= (N-M+1); r++) {
				for (int c = 1; c <= (N-M+1); c++) {
					int flies = prefixSum[(r+M)-1][(c+M)-1] - prefixSum[(r+M)-1][c-1] 
							- prefixSum[r-1][(c+M)-1] + prefixSum[r-1][c-1];
					if (flies > max) max = flies;
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}

}
