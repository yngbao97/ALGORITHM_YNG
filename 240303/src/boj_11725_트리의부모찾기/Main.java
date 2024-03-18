package boj_11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 노드의 개수
		
		// 각 노드의 연결 구조, 인접행렬과 흡사함
		List<Integer>[] nodes = new List[N+1];
		
		// 노드 방문 여부 체크
		boolean[] visited = new boolean[N+1];
		
		// 각 노드의 부모 노드 정보
		int[] parentMap = new int[N+1];
		
		// 입력
		for (int i = 0; i < N-1; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			// 서로의 연결 노드 리스트에 추가, 아직 누가 부모인지 모르니까 공평하게
			if (nodes[num1] == null) {
				nodes[num1] = new ArrayList<>();
			}
			if (nodes[num2] == null) {
				nodes[num2] = new ArrayList<>();
			}
			nodes[num1].add(num2);
			nodes[num2].add(num1);
		}
		
		// bfs 탐색을 위한 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 루트 1은 넣고 시작함
		queue.add(1);
		visited[1] = true;
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			
			// 값 하나 뽑아서
			int nodeNum = queue.poll();
			
			// 해당하는 노드에 연결된 노드들을 큐에 추가, 단 방문하지 않은 곳만
			if (nodes[nodeNum] != null) {
				for (int i : nodes[nodeNum]) {
					if (!visited[i]) {
						queue.add(i);
						visited[i] = true;
						
						// 연결된 노드들의 부모 노드는 현재 노드이므로, 부모맵에 저장
						parentMap[i] = nodeNum;
					}
				}
			}
		}
		
		// 부모맵 2번부터 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parentMap[i]);
		}
		
		// 문단속
		sc.close();
	}

}
