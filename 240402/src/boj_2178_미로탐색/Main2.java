package boj_2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 걸린 시간: 30분
 * 전형적인 bfs 탐색, 최단거리 구하기
 * 가장자리 패딩을 해주니, 델타탐색이 훨씬 편했다.
 * 또, visited 대신 입력으로 주어지지 않는 수를 통해 방문 여부를 판단했다.
 * 두가지 모두 적절히 활용할 수 있는 사례였다.
 * 
 * 하지만 오랜만에 BufferedReader를 사용하려니 사용법 검색이 필요했고,
 * 패딩을 넣는 과정에서 인덱스를 헷갈리고, toCharArray 과정에서 -'0' 을 까먹어 이상한 수가 저장됐다..
 * 다양한 형태의 입력을 처리하는 연습도 다시 해야한다.
 * 
 * 시작지점에서 거리가 0인지 1인지도 잘 확인해야 한다. 중요하다.
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] maze = new int[N+2][M+2];
		
		
		// 미로 입력
		for (int i = 1; i <= N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = tmp[j-1]-'0';
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		queue.add(new int[] {1,1});
		maze[0][0] = 2;
		int cnt = 1;
		
		// 시작지점도 거리에 포함
		int depth = 1;
		
		while(!queue.isEmpty()) {
			
			// 같은 depth의 목록을 모두 방문하면 depth상태를 증가시키고, 현재 queue 사이즈를 저장
			if (cnt == 0) {
				cnt = queue.size();
				depth++;
			}
			
			int[] curr = queue.poll();
			
			// 종료지점을 만나면 종료
			if (curr[0] == N && curr[1] == M) break;
			
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				// 방문하지 않은 미로이면 queue에 저장
				if (maze[nr][nc] == 1) {
					queue.add(new int[] {nr, nc});
					maze[nr][nc] = 2;
				}
			}
			cnt--;
		}
		
		System.out.println(depth);
		br.close();
	}

}
