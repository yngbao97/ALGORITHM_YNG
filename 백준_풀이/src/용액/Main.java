/**
 * Author: yngbao97, Yuk Yejin
 * Problem: 용액_2467
 * Date: 2025.01.03
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
        int[] liq = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) liq[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(liq);

        int a = 0;
        int b = 0;

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = liq[left] + liq[right];
            int gap = Math.abs(sum);
            if (gap < min || gap == 0) {
                a = left;
                b = right;
                min = gap;
                if (min == 0) break;
            }

            if (sum > 0) right--;
            else if (sum < 0) left++;
        }

        bw.write(String.valueOf(liq[a]) + " " + String.valueOf(liq[b]));
		bw.flush();
		bw.close();
		br.close();
	}
}