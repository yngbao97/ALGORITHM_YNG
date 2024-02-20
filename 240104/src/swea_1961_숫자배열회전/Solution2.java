package swea_1961_숫자배열회전;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N]; // 원본배열 + 회전된 배열 3개
		
		// 원본 배열 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		// 모든 회전 배열을 동시에 출력해야 하므로 행길이만큼 크게 반복
		System.out.println("#"+1);
		for (int i = 0; i < N; i++) {
			
			// 90도 회전 배열
			for (int r = N-1; r >= 0; r--) {
				System.out.print(arr[r][i]);
			}
			System.out.print(" ");
			
			// 180도 회전 배열 
			for (int c = N-1; c >= 0; c--) {
				System.out.print(arr[(N-1)-i][c]);
			}
			System.out.print(" ");
			
			// 270도 회전 배열 
			for (int r = 0; r < N; r++) {
				System.out.print(arr[r][(N-1)-i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
