package boj_class;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input," ");
		
		int answer = st.countTokens();
		
		
//		Boolean test;

		System.out.println(answer);

		sc.close();
	}
}
