/*
 * 설계: 10분
 * 풀이: 40분
 * 
 * 위상정렬 기초개념 문제인 것 같아서 골랐다.
 * 알고리즘 수업 당시에 해보고 위상정렬 안해본 것 같아서..감잡을겸
 * 
 * [풀이방법]
 * 1. 입력을 받으면서 각 과목의 선수과목개수(진입차수)와 인접리스트(순서)를 생성한다.
 * 2. 진입차수가 0인 과목(수강 가능한 과목, 첫 학기에 들을 과목)을 큐에 모두 넣는다.
 * 3. 현재 큐 사이즈만큼 과목을 뽑아 다음에 들을 수 있는 과목의 진입차수를 -1 해준다.
 * 		이때, 뽑은 과목의 수강여부를 체크한다.
 * 4. 사이클을 마치면 현재 진입차수가 새롭게 0이 된 과목들을 다시 큐에 추가한다.(다음학기에 들을 과목)
 * 5. 큐가 빌때까지 3, 4번을 반복한다. 단, 큐에 넣을때 다음 학기 차수를 확정하여 입력해둔다.
 */

package boj_14567_선수과목;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 과목 수
		int M = sc.nextInt();	// 조건 수
		
		List<Integer>[] adj = new List[N+1];
		int[] condition = new int[N+1];	// 과목별 진입차수
		int[] answer = new int[N+1];		// 수강하는데 걸리는 총 학기
		boolean[] done = new boolean[N+1];	// 이수여부
		
		// 인접리스트 초기화
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			
			// 선수과목 수강시 다음강의 진입차수를 줄일 수 있도록 인접리스트 추가
			adj[before].add(after);
			
			// 후순위 과목 진입차수 증가
			condition[after]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int season = 1;
		
		// 진입차수가 0인 과목 queue에 추가
		for (int i = 1; i <= N; i++) {
			if (condition[i] == 0) {
				queue.add(i);
				answer[i] = season;
			}
		}
		
		
		// queue가 빌 때까지 반복
		while (!queue.isEmpty()) {
			
			// 이번에 추가되는 과목들의 총 이수학기수
			season++;
			
			// 현재 큐사이즈만큼 카운트 및 반복
			int cnt = queue.size();
			
			
			for (int i = 0; i < cnt; i++) {
				
				// 들을 수 있는 과목(queue) 하나 뽑음
				int subject = queue.poll();
				// 수강완료
				done[subject] = true;
				
				// 이 과목 이후 들을 수 있는 과목 돌면서 진입차수 줄여주기
				for (int next : adj[subject]) {
					// 이미 수강한 과목이면 패스
					if (!done[next]) {
						condition[next]--;
					}
				}
			}
			
			// 전체과목 돌면서 아직 수강하지 않았고 진입차수가 0인 과목 큐에 추가
			// 추가하면서 이수에 필요한 학기 수 확정
			for (int i = 1; i <= N; i++) {
				if (!done[i] && condition[i] == 0) {
					queue.add(i);
					answer[i] = season;
				}
			}
		}
		
		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(answer[i] + " ");
		}
		
		sc.close();
	}
}