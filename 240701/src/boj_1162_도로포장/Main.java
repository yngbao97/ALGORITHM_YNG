package boj_1162_도로포장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);	// 도시의 수
		int M = Integer.parseInt(info[1]);	// 도로의 수
		int K = Integer.parseInt(info[2]);	// 포장할 도로의 수
		
		List<Node>[] adj = new List[N+1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().split(" ");
			int v1 = Integer.parseInt(tmp[0]);
			int v2 = Integer.parseInt(tmp[1]);
			int w = Integer.parseInt(tmp[2]);
			
			adj[v1].add(new Node(v2, w, 1 << v2));
			adj[v2].add(new Node(v1, w, 1 << v1));
		}
		
		boolean[] visited = new boolean[N+1];
		int[] road = new int[N+1];
		int[] dist = new int[N+1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[1] = true;
		pq.addAll(adj[1]);
		
		while (!pq.isEmpty()) {
			
			Node curr = pq.poll();
			
			if (visited[curr.next]) continue;
			visited[curr.next] = true;
			
			for (Node n : adj[curr.next]) {
				if (dist[n.next] > curr.w + n.w) {
					dist[n.next] = curr.w + n.w;
					road[n.next] = curr.root | n.root;
					pq.add(new Node(n.next, dist[n.next], road[n.next]));
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(road));
		
		br.close();
	}
}

class Node implements Comparable<Node>{
	int next;
	int w;
	int root;
	
	Node (int next, int w, int root) {
		this.next = next;
		this.w = w;
		this.root = root;
	}
	
	@Override
	public int compareTo(Node n) {
		return w - n.w;
	}
	
}