package swea_4613_러시아국기같은깃발;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_4613_러시아국기같은깃발/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] input = sc.nextLine().split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			
			int[] forWhite = new int[row];
			int[] forBlue = new int[row];
			int[] forRed = new int[row];
			
			for (int r = 0; r < row; r++) {
				char[] rowInput = sc.nextLine().toCharArray();
				for (int c = 0; c < col; c++) {
					if (rowInput[c] != 'W') forWhite[r]++;
					if (rowInput[c] != 'B') forBlue[r]++;
					if (rowInput[c] != 'R') forRed[r]++;
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < row-1; i++) {
				for (int j = i+1; j < row; j++) {
					int chCnt = 0;
					for (int k = 1; k < row-1; k++) {
						if (k < i) chCnt += forWhite[k];
						else if (k >= i && k < j) chCnt += forBlue[k];
						else chCnt += forRed[k];
					}
					if (chCnt < min) min = chCnt;
				}
			}
			min += forWhite[0] + forRed[row-1];
			
			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();
	}
}
