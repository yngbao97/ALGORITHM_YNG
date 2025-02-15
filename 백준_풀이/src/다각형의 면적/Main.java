/**
 * Author: yngbao97, Yuk Yejin
 * Problem: 다각형의 면적_2166
 * Date: 2025.01.02
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long[][] points = new long[n+1][];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			points[i] = new long[]{x, y};
		}
		points[n] = new long[]{points[0][0], points[0][1]};

		long answer = 0;
		for (int i = 0; i < n; i++) {
			answer += (points[i][0] * points[i+1][1]) - (points[i+1][0] * points[i][1]);
		}

		bw.write(String.format("%.1f", Math.abs(answer) / 2.00));
		bw.flush();
		bw.close();
		br.close();
	}
}