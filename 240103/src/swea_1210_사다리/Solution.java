package swea_1210_사다리;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
        int N = 100;
        int[][] ladder = new int[N][N];
        int rowIdx = 0;
        int colIdx = 0; 

        for (int r = 0; r < N; r++) {
            for (int c =0; c < N; c++) {
                ladder[r][c] = sc.nextInt();
            }
        }

        int[] lrDc = {-1, 1};

        int direction = 0;

        for (int c = 0; c < N; c++) {
            if (ladder[N-1][c] == 2) {
                rowIdx = N-2;
                colIdx = c;
            }
        }

        while (rowIdx != 0) {
            for (int r = rowIdx; r >= 0; r--) {  //  수직으로 올라가면서
            	if (r == 0) {
            		rowIdx = r;
                	break;
            	}
                for (int d = 0; d < 2; d++) {  // 좌우를 살핀다.
                    int nc = colIdx + lrDc[d];
                    if (nc >= 0 && nc < N) {
                        if (ladder[r][nc] == 1) { // 값이 1인지 비교해서
                            direction = d;  // 해당 방향의 델타 값을 저장한다.
                            rowIdx = r;  // 발견한 1이 위치한 값을 저장한다.
                            colIdx = nc;
                            break;
                        } 
                    }
                }
                if (ladder[rowIdx][colIdx] == 1) break; // 반복문을 다시 나가기 위한 조건, 중첩 반복문 정리 필
            }
            
            for (int c = colIdx; rowIdx != 0 && (c >= 0 || c < N) ; c += lrDc[direction]) {
            	int nr = rowIdx - 1; // 위쪽 좌표를 구한다.
                
                if (ladder[nr][c] == 1) { // 위의 값이 1이면
                    rowIdx = nr;  // 발견한 1이 위치한 값을 저장한다.
                    colIdx = c;
                    break;
                } 
            }
        }
        System.out.printf("#%d %d\n", testCase, colIdx);
        sc.close();
	}

}
