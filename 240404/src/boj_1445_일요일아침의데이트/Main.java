package boj_1445_일요일아침의데이트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int INF = 2_500;
	static char[][] forest;
	static int[][] num;
	static int[][][] dist;
	static int N;
	static int M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		forest = new char[N][M];
		num = new int[N][M];
		dist = new int[N][M][2];
		List<int[]> garbage = new ArrayList<>();
		
		int[] start = new int[2];
		int[] end = new int[2];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j = 0; j < M; j++) {
				forest[i][j] = tmp[j];
				if (forest[i][j] == 'S') {
					start = new int[] {i, j};
				} else if (forest[i][j] == 'F') {
					end = new int[] {i, j};
				} else if (forest[i][j] == 'g') {
					garbage.add(new int[] {i, j});
					num[i][j] = 2;
				}
			}
		}
		
		// 쓰레기 칸 2, 쓰레기 옆 칸 1
		for (int[] loc : garbage) {
			for(int i = 0; i < 4; i++) {
				int nr = loc[0] + dr[i];
				int nc = loc[1] + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || num[nr][nc] != 0) continue;
				
				num[nr][nc] = 1;
			}
		}
		
		print(num);
		
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(dist[i], INF);
//		}
		
		dijkstra(start, end);
		
//		System.out.println(answer[0]+" "+answer[1]);
		sc.close();
	}
	
	private static void dijkstra(int[] start, int[] end) {
//		int[] answer = new int[2];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		dist[start[0]][start[1]] = new int[] {0, 0};
		num[start[0]][start[1]] = 0;
		// 출발점은 세지 않는다 따라서 0
		queue.add(new Node(start[0], start[1], 0, 0));
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			int gCnt = curr.gCnt;
			int sCnt = curr.sCnt;
			
//			// 쓰레기 옆길이면
//			if (num[curr.r][curr.c] == 1) nDis = 1;
//			// 쓰레기 정통이면
//			else if (num[curr.r][curr.c] == 2) nDis = 2;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (num[nr][nc] == 0 && dist[nr][nc][0] > gCnt) {
					dist[nr][nc][0] = gCnt;
					dist[nr][nc][1] = sCnt;
					
				} else if (num[nr][nc] == 1) {
					if (dist[nr][nc][0] > gCnt) {
						
					}
				}
//				// 쓰레기가 있는 칸이고, 저장된 값이 지금 가려는 길보다 더러우면
//				if (forest[nr][nc] == 'g' && dist[nr][nc][0] > gCnt+num[nr]) {
//					dist[nr][nc][0] = gCnt;
//					dist[nr][nc][1] = sCnt;
//					dist[nr][nc] = curr.sum + 2;
//					queue.add(new Node(nr, nc, 2, dist[nr][nc]));
//					
//				} else if (forest[nr][nc] == '.') {
//					
//					if (num[nr][nc] == 0 && dist[nr][nc] > curr.sum) {
//						dist[nr][nc] = curr.sum;
//						queue.add(new Node(nr, nc, 0, dist[nr][nc]));
//					} else if (num[nr][nc] == 1 && dist[nr][nc] > curr.sum+1) {
//						dist[nr][nc] = curr.sum+1;
//						queue.add(new Node(nr, nc, 1, dist[nr][nc]));
//					}
					
//				} else if (forest[nr][nc] == 'F') {
//					dist[nr][nc] = curr.sum;
//					return;
//				}
			}
		}
	}

	private static void print(int[][] num2) {

		for (int i = 0; i < num2.length; i++) {
			System.out.println(Arrays.toString(num2[i]));
		}
	}
}

class Node implements Comparable<Node>{
	int r;
	int c;
	int gCnt;
	int sCnt;
	
	Node (int r, int c, int gCnt, int sCnt) {
		this.r = r;
		this.c = c;
		this.gCnt = gCnt;
		this.sCnt = sCnt;
	}

	@Override
	public int compareTo(Node o) {
		if (gCnt == o.gCnt) {
			return Integer.compare(sCnt, sCnt);
		}
		return Integer.compare(gCnt, o.gCnt);
	}
	
}
