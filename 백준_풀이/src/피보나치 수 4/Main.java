/**
 * Author: yngbao97, Yuk Yejin
 * Problem: 피보나치 수 4_10826
 * Date: 2024.12.07
 */

import java.math.BigInteger;
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

        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {
            BigInteger tmp = first;
            first = second;
            second = tmp.add(first);
        }

        if (n == 0) bw.write(first.toString());
        else bw.write(second.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}