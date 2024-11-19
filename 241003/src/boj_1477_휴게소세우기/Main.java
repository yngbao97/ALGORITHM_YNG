package boj_1477_휴게소세우기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 휴게소 개수
		int M = sc.nextInt();	// 추가할 개수
		int L = sc.nextInt();	// 고속도로 길이
		
		List<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr, Collections.reverseOrder());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		pq.add(L - arr.get(0));
		for (int i = 0; i < N-1; i++) {
			pq.add(arr.get(i) - arr.get(i+1));
		}
		pq.add(arr.get(N-1));
		
		for (int i = 0; i < M; i++) {
			int dist = pq.poll();
			int a = dist / 2;
			int b = dist - a;
			pq.add(a);
			pq.add(b);
		}
		
		System.out.println(pq.poll());
		sc.close();
	}

}
