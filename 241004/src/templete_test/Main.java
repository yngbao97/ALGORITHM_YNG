package templete_test;

/**
 * Author: yngbao97, Yuk Yejin
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new InputStreamReader(new FileInputStream("src/"+Main.class.getPackage().getName()+"/input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(br.readLine());

		bw.flush();
		bw.close();
		br.close();

	}
}
