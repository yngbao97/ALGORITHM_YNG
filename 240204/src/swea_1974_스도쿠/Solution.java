package swea_1974_스도쿠;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_1974_스도쿠/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[][] sudoku = new int[9][9];
			int[] check;
			int answer = 1;
			
			for (int r = 0; r < 9; r++) {
				check = new int[10];
				
				for (int c = 0; c < 9; c++) {
					sudoku[r][c] = sc.nextInt();
					if (check[sudoku[r][c]]++ > 0) answer = 0;
				}
			}
			
			if (answer != 0) {
				out: for (int c = 0; c < 9; c++) {
					check = new int[10];
					
					for (int r = 0; r < 9; r++) {
						if (check[sudoku[r][c]]++ > 0) {
							answer = 0;
							break out;
						}
					}
				}
			}
			
			if (answer != 0) {
				out: for (int i = 0; i < 9; i += 3) {
					for (int j = 0; j < 9; j += 3) {
						check = new int[10];
						
						for (int r = i; r < i+3; r++) {
							for (int c = j; c < j+3; c++) {
								if (check[sudoku[r][c]]++ > 0) {
									answer = 0;
									break out;
								}
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}
}
