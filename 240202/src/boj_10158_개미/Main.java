package boj_10158_개미;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int time = sc.nextInt();
		
		/*
		 * 처음 위치에서 이동시간만큼 더한뒤 0으로 돌아오는 간격(2W)으로 나누어 나머지를 구한다.
		 * 나머지가 W보다 큰 경우 범위를 벗어나므로, 2W에서 나머지를 빼주면 반대끝 지점에서 나머지만큼 돌아온 지점이 된다.
		 */
		int x = (P + time) % (2 * W);
		int y = (Q + time) % (2 * H);
		if (x > W) x = (2 * W) - x;
		if (y > H) y = (2 * H) - y;
		
		System.out.println(x+" "+y);
		sc.close();
	}
}
