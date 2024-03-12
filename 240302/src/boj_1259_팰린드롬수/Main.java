package boj_1259_팰린드롬수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String answer = "yes";
			String input = sc.nextLine();
			if (input.equals("0")) break;
			
			char[] number = input.toCharArray();
			for (int i = 0, j = input.length()-1; i < input.length()/2; i++, j--) {
				if (number[i] != number[j]) {
					answer = "no";
					break;
				}
			}
			
			System.out.println(answer);
		}
		sc.close();
	}
}