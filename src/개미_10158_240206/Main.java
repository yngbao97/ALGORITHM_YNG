package 개미_10158_240206;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int time = sc.nextInt();
		
		int pDirec = 1;
		int qDirec = 1;
		for (int i = 0; i < time; i++) {
			if (P == 0 || P == W) pDirec *= -1;
			if (Q == 0 || Q == H) qDirec *= -1;
			P += pDirec;
			Q += qDirec;
		}
		
		
		
		System.out.println(P+" "+Q);
		sc.close();
	}
}
