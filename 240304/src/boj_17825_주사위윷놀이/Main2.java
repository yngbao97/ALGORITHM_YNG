package boj_17825_주사위윷놀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	static int[] order;
	static int[] move;
	static int[][] marker;
	static boolean[] outOfMap;
	static List<Integer>[] map;
	static boolean[][] visited;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		order = new int[10];
		move = new int[10];
		
		for (int i = 0; i < 10; i++) {
			order[i] = sc.nextInt();
		}
		
		// 게임판 입력... 바보같다. 규칙못찾아서 냅다 입력
		map = new ArrayList[5];
		map[0] = new ArrayList<>();
		for (int j = 2; j <= 40; j += 2) {
			map[0].add(j);
		}
		map[1] = new ArrayList<>(List.of(10, 13, 16, 19, 25));
		map[2] = new ArrayList<>(List.of(20, 22, 24, 25));
		map[3] = new ArrayList<>(List.of(30, 28, 27, 26, 25));
		map[4] = new ArrayList<>(List.of(25, 30, 35, 40));
		
		// 말 움직일 순서 정하자(중복 순열)
		answer = 0;
		perm(0);
		
		System.out.println(answer);
		
		sc.close();
	}
	
	private static void perm(int cnt) {
		if (cnt >= 10) {
			answer = Math.max(answer, game());
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			move[cnt] = i;
			perm(cnt+1);
		}
	}

	private static int game() {
		// 말 위치 초기화 - 도착점은 {0, 20}
		marker = new int[4][2];
		outOfMap = new boolean[4];
		visited = new boolean[5][20];
		for (int i = 0; i < 4; i++) {
			marker[i][1] = -1;
		}
		
		int score = 0;
		out: for (int i = 0; i < 10; i++) {
			if (outOfMap[move[i]]) return 0;
			
			int r = marker[move[i]][0];
			int c = marker[move[i]][1];
			
			if (c+order[i] < 20 && visited[r][c+order[i]]) return 0;
			
			for (int j = 0; j < order[i]; j++) {
				if (r == 0 && c == 19) {
					visited[marker[move[i]][0]][marker[move[i]][1]] = false;
					outOfMap[move[i]] = true;
					continue out;
				}
				c++;
				if (map[r].get(c) == 25) {
					r = 4;
					c = 0;
				} else if (map[r].get(c) == 40) {
					r = 0;
					c = 19;
				} 
			}
			
			if (map[r].get(c) == 10) {
				r = 1;
				c = 0;
			} else if (map[r].get(c) == 20) {
				r = 2;
				c = 0;
			} else if (map[r].get(c) == 30) {
				r = 3;
				c = 0;
			}
			
			if (visited[r][c]) return 0;
			score += map[r].get(c);
			
			// 말 위치 갱신
			if (marker[move[i]][1] > -1) {
				visited[marker[move[i]][0]][marker[move[i]][1]] = false;
			}
			visited[r][c] = true;
			marker[move[i]] = new int[] {r, c};
			
			
		}
		
		return score;
	}
}
