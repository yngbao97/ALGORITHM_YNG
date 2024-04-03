/*
 * 해결하지 못했다..
 * 단순히 순열, 조합 구조로 풀수 있을 줄 알았는데
 * 결과 중복 확인을 통해 걸러내는 구조라서 이런 해결은 당장 필요하지 않다.
 * 더 좋은 풀이가 있다면 따라해봐야겠다.
 * 일단 지금은 여기서 그만..
 * 
 * 알게된 점은 StringBuilder 를 빠르게 초기화 하는 방법은 sb.setLength(0)이라는 것이다.
 * 그리고 문자열끼리의 정렬은 숫자와의 정렬과 달라서 문자 하나씩 비교하기 때문에 9와 10을 비교하면 10이 더 작다고 나올 것이다.
 * 유의하자.
 */
package boj_15663_N과M_9;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static boolean[] visited;
	static int[] sel;
	static Set<String> output;
	static List<String> answers;
	static StringBuilder sb;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		sb = new StringBuilder();
		output = new HashSet<>();
		perm(0);
		
		answers = new ArrayList<>();
		
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if (cnt >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]+" ");
			}
			if (!output.contains(sb.toString())) {
				output.add(sb.toString());
				for (int i = 0; i < M; i++) {
					
				}
			}
			sb.setLength(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				sel[cnt] = nums[i];
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
