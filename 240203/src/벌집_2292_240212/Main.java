package 벌집_2292_240212;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num = 1;
		int cnt = 1;
		int answer = 1;
		
		while(N != 1) {
			if (N > num && N <= num+(6*cnt)) {
				answer = cnt+1;
				break;
			} else num += 6*cnt++;
		}
		
		System.out.println(answer);
		sc.close();
	}
}
