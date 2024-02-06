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
		
		int x = time-(W-P);
		int y = time-(H-Q);
		if ((x/W)%2 == 0) P = W - (x%W);
		else P = 0 + (x%W);
		if ((y/H)%2 == 0) Q = H - (y%H);
		else Q = 0 + (y%H);
		
		System.out.println(P+" "+Q);
		sc.close();
	}
}
