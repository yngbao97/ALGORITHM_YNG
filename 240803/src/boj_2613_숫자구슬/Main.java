package boj_2613_숫자구슬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] marbles;
	static int[] groupCount;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		marbles = new int[N];
		groupCount = new int[M];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			marbles[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = bs(1, N * 100);
		isPossible(answer);
		
		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		for (int n : groupCount) sb.append(n + " ");
		System.out.println(sb.toString());
		br.close();
		
	}
	
	private static int bs(int start, int end) {
		
		if (start >= end) return start;
		
		int mid = (start + end) / 2;
		
		if (isPossible(mid)) return bs(start, mid);
		else return bs(mid+1, end);
		
	}

	private static boolean isPossible(int max) {

		int idx = 0;
		
		for (int i = 0; i < M; i++) {
			
			if (idx >= N) return true;
			
			groupCount[i] = 0;
			int sum = 0;
			
			while (idx < N && sum + marbles[idx] <= max) {
				sum += marbles[idx++];
				groupCount[i]++;
			}
		}
		
		if (idx != N) return false;
		return true;
	}
}
