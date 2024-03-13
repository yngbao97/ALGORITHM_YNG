package boj_1654_랜선자르기;

import java.util.Scanner;
/*
 * 이진탐색으로 풀어야 함! 아니면 시간초과 날걸
 * 대신 탈출조건을 잘 써주자!
 * N개만큼 랜선을 만들 수 있어도, 가능한 최대길이를 찾아야해서 탐색은 다 해봐야해!
 */
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();		// 오영식이 가진 랜선 개수
		long N = sc.nextInt();		// 필요한 랜선 개수
		
		long sum = 0;
		long[] lan = new long[K];
		
		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			sum += lan[i];
		}
		
		long right = sum / N;
		long left = 1;
		long standard = right;
		long answer = 0;
		
		while (true) {
			int cnt = 0;
			
			for (long line : lan) {
				cnt += line / standard;
			}
			
			if (cnt >= N) {
				if (standard > answer) answer = standard;
				left = standard;
				standard = (left+right) / 2;
			} else {
				right = standard;
				standard = (left+right) / 2;
			}
			
			if (left >= right || standard == left || standard == right) break;
		}
		
		System.out.println(standard);
		sc.close();
	}
}