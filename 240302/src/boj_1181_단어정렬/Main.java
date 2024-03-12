package boj_1181_단어정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		List<String> words = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String input = sc.nextLine();
			if (!words.contains(input)) {
				words.add(input);
			}
		}
		
		Collections.sort(words, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		
		for (String word : words) {
			System.out.println(word);
		}
		
		sc.close();
	}
}