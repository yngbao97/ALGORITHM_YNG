package 코테_boj_2295_세수의합;

/**
 * Author: yngbao97, Yuk Yejin
 * Problem: 코테_boj_2295_세수의합
 * Date: 2025.01.09
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			set.add(arr[i]);
		}
		Arrays.sort(arr);

		int ans = 0;

		out: for (int k = N - 1; k >= 0; k--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (set.contains(arr[k] - (arr[i] + arr[j]))) {
						System.out.println(arr[k]);
						break out;
					}
				}
			}
		}
	}
}