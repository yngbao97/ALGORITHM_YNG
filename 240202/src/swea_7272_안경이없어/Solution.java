package swea_7272_안경이없어;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/안경이없어_7272_240207/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String ans = "SAME";
			String[] words = sc.nextLine().split(" ");
			if (words[0].length() == words[1].length()) {
				String[] first = words[0].split("");
				String[] second = words[1].split("");
				for (int i = 0; i < words[0].length(); i++) {
					if (map(first[i]) != map(second[i])) ans = "DIFF";
				}
			} else ans = "DIFF";
			System.out.printf("#%d %s\n", tc, ans);
		}
		sc.close();
	}
	
	public static int map(String str) {
		
		String hole_0 = "CEFGHIJKLMNSTUVWXYZ";
		String hole_1 = "ADOPQR";
		
		if (hole_0.contains(str)) return 0;
		else if (hole_1.contains(str)) return 1;
		else return 2;
	}
}
