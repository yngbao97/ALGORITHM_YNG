package boj_2606_바이러스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 컴퓨터 개수
		int M = sc.nextInt(); 		// 네트워크 연결 수 
		List<Integer>[] net = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if (net[A] == null) {
				net[A] = new ArrayList<>();
			}
			if (net[B] == null) {
				net[B] = new ArrayList<>();
			}
			net[A].add(B);
			net[B].add(A);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			
			if (tmp != 1) answer++;
			
			if (net[tmp] != null && net[tmp].size() > 0) {
				for (int com : net[tmp]) {
					if (!visited[com]) {
						queue.add(com);
						visited[com] = true;
					}
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
