package boj_1388_바닥장식;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static char[][] design;
	static boolean[][] checked;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		design = new char[N][M];
		checked = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			design[r] = sc.nextLine().toCharArray();
		}
		
		answer = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!checked[r][c]) {
					
					// 해당 좌표값과 문자 정보 전달
					count(r, c, design[r][c]);
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	public static void count(int r, int c, char pattern) {
		// 범위를 벗어났거나, 이전 값과 문자가 다르거나, 이미 체크한 곳을 만나면 answer +1 후 return
		if (r < 0 || r >= N || c < 0 || c >= M || 
				design[r][c] != pattern || checked[r][c]) {
			answer++;
			return;
		}
		
		// 정상적으로 이어진 곳이면 체크표시
		checked[r][c] = true;
		
		// -이면 같은행 옆으로, |이면 같은열 아래쪽으로 이동해서 검사
		if (design[r][c] == '-') {
			count(r, c+1, '-');
		} else {
			count(r+1, c, '|');
		}
		
	}

}
