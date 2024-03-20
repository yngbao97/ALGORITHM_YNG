package boj_1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

	static char[] alpha;
	static boolean[] select;
	static int L;
	static int C;
	static int N;
	static int[] vowelIdx;
	static int[] consIdx;
	static int vowelCnt;
	static int consCnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		L = Integer.parseInt(nums[0]);
		C = Integer.parseInt(nums[1]);
		alpha = new char[C];
		select = new boolean[C];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		vowelIdx = new int[C];
		consIdx = new int[C];
		vowelCnt = 0;
		consCnt = 0;
		
		// 입력
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
//		System.out.println(Arrays.toString(alpha));
		for (int i = 0; i < C; i++) {
			if (alpha[i] == 'a' || alpha[i] == 'i' || alpha[i] == 'u' || alpha[i] == 'e' || alpha[i] == 'o') vowelIdx[vowelCnt++] = i;
			else consIdx[consCnt++] = i;
		}
		
		vowelIdx = Arrays.copyOf(vowelIdx, vowelCnt);
		consIdx = Arrays.copyOf(consIdx, consCnt);
		
		int cnt = 0;
		if (L < 7) cnt = L-2;
		else cnt = 5;
		
		for (int i = 1; i <= cnt; i++) {
			N = i;
			vowelComb(0, 0);
		}

		br.close();
	}
	
	private static void vowelComb(int idx, int cnt) {
		if (cnt >= N) {
			consComb(0, 0);
			return;
		}
		
		if (idx >= vowelCnt) return;
		
		select[vowelIdx[idx]] = true;
		vowelComb(idx+1, cnt+1);
		select[vowelIdx[idx]] = false;
		vowelComb(idx+1, cnt);
	}

	private static void consComb(int idx, int cnt) {
		if (cnt == L-N) {
			String tmp = "";
			for (int i = 0; i < C; i++) {
				if (select[i]) {
					tmp += alpha[i];
				}
			}
			System.out.println(tmp);
			return;
		}
		
		if (idx >= consCnt) return;
		
		select[consIdx[idx]] = true;
		consComb(idx+1, cnt+1);
		select[consIdx[idx]] = false;
		consComb(idx+1, cnt);
	}

}
