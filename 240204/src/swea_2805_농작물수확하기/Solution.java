package swea_2805_농작물수확하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_2805_농작물수확하기/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			int[][] field = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				char[] input = sc.nextLine().toCharArray();
				for (int c = 0; c < N; c++) {
					field[r][c] = input[c] - '0';
				}
			}
			
			int left = N/2, right = N/2;
			int answer = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = left; c <= right; c++) {
					answer += field[r][c];
				}
				if (r < N/2) {
					left--;
					right++;
				} else {
					left++;
					right--;
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}
}
