package BOJ_16953_AB;

/**
 * Author: yngbao97, Yuk Yejin
 */

import java.io.*;
import java.util.*;

public class Main2 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static long A;
	static long B;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new InputStreamReader(new FileInputStream("src/"+Main.class.getPackage().getName()+"/input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		
		A = Long.parseLong(input[0]);
		B = Long.parseLong(input[1]);
		
		visited = new boolean[(int) (B+1)];
		
		long answer = -1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(A, 0));
		
		while (!pq.isEmpty()) {
			
			Node curr = pq.poll();
			
			if (curr.number == B) {
				answer = curr.count + 1;
				break;
			}
			
			long first = curr.number * 2;
			long second = (curr.number * 10) + 1;
			
			if (first <= B) pq.add(new Node(first, curr.count + 1));
			if (second <= B) pq.add(new Node(second, curr.count + 1));
		}
		
		bw.append(String.valueOf(answer));

		bw.flush();
		bw.close();
		br.close();

	}
}

class Node implements Comparable<Node>{
	long number;
	long count;
	
	Node (long number, long count) {
		this.number = number;
		this.count = count;
	}

	@Override
	public int compareTo(Node o) {
		if (this.number == o.number) {
			return Long.compare(this.count, o.count);
		}
		return Long.compare(this.number, number);
	}
}
