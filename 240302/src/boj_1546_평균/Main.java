package boj_1546_평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double N = sc.nextInt();
		double[] scores = new double[(int)N];
		double max = Integer.MIN_VALUE;
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
			if (scores[i] > max) max = scores[i];
		}
		
		for (int i = 0; i < N; i++) {
			scores[i] = scores[i]/max*100;
			sum += scores[i];
		}
		
		System.out.println(sum/N);
		sc.close();
	}
}