package boj_14500_테트로미노;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] arr = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		boolean[][] T = new boolean[2][3];
		boolean[][] Z = new boolean[2][3];
		boolean[][] L = new boolean[2][3];
		
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 1 || c == 1) T[r][c] = true;
				if ((r == 0 && c < 2) || (r == 1 && c > 0)) Z[r][c] = true;
				if (!(r == 0 && c > 0)) L[r][c] = true;
			}
		}
		
		int max = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int temp;
				
				if (r < row-1 && c < col-1) {
					temp = arr[r][c] + arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1];
					if (temp > max) max = temp;
				}
				
				if (c < col-3) {
					temp = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r][c+3];
					if (temp > max) max = temp;
				}
				
				if (r < row-3) {
					temp = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r+3][c];
					if (temp > max) max = temp;
				}
				
				if (r < row-1 && c < col-2) {
					int[] sum = new int[8];
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < 3; j++) {
							
							if (T[i][j]) sum[0] += arr[r+i][c+j];
							
							if (T[1-i][j]) sum[1] += arr[r+i][c+j];
							
							if (Z[i][j]) sum[2] += arr[r+i][c+j];
							
							if (Z[1-i][j]) sum[3] += arr[r+i][c+j];
							
							if (L[i][j]) sum[4] += arr[r+i][c+j];
							
							if (L[1-i][j]) sum[5] += arr[r+i][c+j];
							
							if (L[i][2-j]) sum[6] += arr[r+i][c+j];
							
							if (L[1-i][2-j]) sum[7] += arr[r+i][c+j];
						}
					}
					
					for (int i = 0; i < 8; i++) {
						if (sum[i] > max) max = sum[i];
					}
				}
				
				if (r < row-2 && c < col-1) {
					int[] sum = new int[8];
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < 3; j++) {
							
							if (T[i][j]) sum[0] += arr[r+j][c+i];
							
							if (T[1-i][j]) sum[1] += arr[r+j][c+i];
							
							if (Z[i][j]) sum[2] += arr[r+j][c+i];
							
							if (Z[1-i][j]) sum[3] += arr[r+j][c+i];
							
							if (L[i][j]) sum[4] += arr[r+j][c+i];
							
							if (L[1-i][j]) sum[5] += arr[r+j][c+i];
							
							if (L[i][2-j]) sum[6] += arr[r+j][c+i];
							
							if (L[1-i][2-j]) sum[7] += arr[r+j][c+i];
						}
					}
					
					for (int i = 0; i < 8; i++) {
						if (sum[i] > max) max = sum[i];
					}
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}
