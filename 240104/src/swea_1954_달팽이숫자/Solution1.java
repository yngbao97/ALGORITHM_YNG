package swea_1954_달팽이숫자;

import java.util.Scanner;

public class Solution1 {

	public static void main(String args[]) throws Exception {
		
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int maxNum = N * N;
            int cnt = 1;
            int row = 0;
            int cul = 0;
            int move = 1;
            int chDirec = -1;
 
            while (true) {
                while (cul >= 0 && cul < N && arr[row][cul] == 0) {
                    arr[row][cul] = cnt++;
                    cul += move;
                }
                row += move;
                cul -= move;
                while (row >= 0 && row < N && arr[row][cul] == 0) {
                    arr[row][cul] = cnt++;
                    row += move;
                }
                if (cnt > maxNum) break;
                row -= move;
                cul -= move;
                move *= chDirec;
            }
 
            System.out.println("#"+test_case);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(arr[r][c]+" ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
