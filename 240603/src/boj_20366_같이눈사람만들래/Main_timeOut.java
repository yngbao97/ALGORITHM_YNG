package boj_20366_같이눈사람만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_timeOut {
	
	static int[] select;
	static boolean[] elsa;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] balls = new int[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			balls[i] = Integer.parseInt(input[i]);
		}

		select = new int[4];
		answer = Integer.MAX_VALUE;
		
		for (int a = 0; a < N-3; a++) {
			select[0] = balls[a];
			for (int b = a+1; b < N-2; b++) {
				select[1] = balls[b];
				for (int c = b+1; c < N-1; c++) {
					select[2] = balls[c];
					for (int d = c+1; d < N; d++) {
						select[3] = balls[d];
						elsa = new boolean[4];
						comb(0, 0);
					}
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	private static void comb(int idx, int cnt) {
		if (cnt >= 2) {
			answer = Math.min(answer, cal());
			return;
		}
		
		if (idx >= 4) return;
		
		elsa[cnt] = true;
		comb(idx+1, cnt+1);
		elsa[cnt] = false;
		comb(idx+1, cnt);
		
	}
	
	private static int cal() {
		int el = 0; 
		int an = 0;
		
		for (int i = 0; i < 4; i++) {
			if (elsa[i]) el += select[i];
			else an += select[i];
		}
		
		return Math.abs(el - an);
	}
}