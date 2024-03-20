package boj_1010_다리놓기;

/*
 * 자료형이 문제인것 같은데 해결이 안된당
 * 모르겠당
 */
import java.util.Scanner;

public class Main {

	static long N;
	static long M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			long answer = 1;
//			for (int i = 0; i < N; i++) {
//				answer *= (M-i)/(N-i);
//			}
			for (int i = 0; i < N; i++) {
				answer = fact(M, 0)/ fact(N, 0);
			}
			System.out.println(answer);
		}
		sc.close();
	}
	
	private static long fact(long num, long cnt) {
		if (cnt >= N) return 1;
		return num*fact(num-1, cnt+1);
	}
}
