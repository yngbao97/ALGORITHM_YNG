package swea_1961_숫자배열회전;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][][] arrRot = new int[4][N][N]; // 원본배열 + 회전된 배열 3개
		int[][] arrLine = new int[3][N*N]; // 배열 회전을 위한 임시 저장소
		
		// 원본 배열 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arrRot[0][r][c] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 3; i++) {
			// 열 우선 역방향 순회로 배열 순서 임시 저장
			int lineIdx = 0;
			for (int c = 0; c < N; c++) {
				for (int r = (N-1); r >= 0; r--) {
					arrLine[i][lineIdx++] = arrRot[i][r][c];
				}
			}
			// 인덱스 번호 초기화 및 arrRot 배열 다음 순서에 차례대로 입력
			lineIdx = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arrRot[i+1][r][c] = arrLine[i][lineIdx++];
				}
			}
		}
		
		// 회전된 배열 출력
		System.out.println("#"+1);
		for (int r = 0; r < N; r++) {
			for (int i = 1; i <= 3; i++) {
				for (int c = 0; c < N; c++) {
					System.out.print(arrRot[i][r][c]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
