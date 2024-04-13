package boj_9370_미확인도착지;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = 20_000_000;
	static int start;
	static int[] p;
	static boolean[] visited;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int t = sc.nextInt();
			
			start = sc.nextInt();
			int smellSt = sc.nextInt();
			int smellEd = sc.nextInt();
			
			int[][] adj = new int[n+1][n+1];
			int[] dist = new int[n+1];
			p = new int[n+1];
			int[] can = new int[t];		// 도착 후보지
			visited = new boolean[n+1];
			
			for (int i = 0; i < m; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int W = sc.nextInt();
				
				adj[A][B] = W;
				adj[B][A] = W;
			}
			
			for (int i = 0; i < t; i++) {
				can[i] = sc.nextInt();
			}
			
			for (int i = 0; i <= n; i++) {
				dist[i] = INF;
				p[i] = i;
			}
			
			PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
				return dist[o1] - dist[o2];
			});
			dist[start] = 0;
			queue.add(start);
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (visited[curr]) continue;
				visited[curr] = true;
				
				for (int i = 1; i <= n; i++) {
					if (adj[curr][i] != 0 && !visited[i]) {
						if (dist[i] > dist[curr]+adj[curr][i]) {
							dist[i] = dist[curr]+adj[curr][i];
							p[i] = curr;
						}
						queue.add(i);
					}
				}
			}
			List<Integer> answer = new ArrayList<>();
			int restart;
			if (dist[smellSt] <= dist[smellEd]) {
				if (dist[smellSt] == dist[smellEd]) {
					for (int i = 0 ; i < t; i++) {
						if (can[i] == smellSt) answer.add(smellSt);
					}
				}
				restart = smellEd;
			} else {
				restart = smellSt;
			}
			
			visited = new boolean[n+1];
			
			visit(restart);
			
			queue.add(restart);
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (visited[curr]) continue;
				visited[curr] = true;
				
				for (int i = 1; i <= n; i++) {
					if (adj[curr][i] != 0 && !visited[i]) {
						if (dist[i] == dist[curr]+adj[curr][i]) {
							p[i] = curr;
						}
						queue.add(i);
					}
				}
			}
			
			p[restart] = restart;
			
			for (int i = 0; i < t; i++) {
				if (findSet(can[i]) == restart) {
					answer.add(can[i]);
				}
			}
			
			Collections.sort(answer);
			
			StringBuilder sb = new StringBuilder();
			for (int i : answer) {
				sb.append(i+" ");
			}
			
			System.out.println(sb.toString());
		}
		sc.close();
	}

	private static void visit(int curr) {
		if (curr == start) return;
		visited[p[curr]] = true;
		visit(p[curr]);
	}

	private static int findSet(int x) {
		if (p[x] == x) return p[x];
		
		return p[x] = findSet(p[x]);
	}
}
