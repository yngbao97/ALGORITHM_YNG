package 참외밭_2477_240209;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();		// 면적당 참외 개수
		int[] sides = new int[6];
		
		int firstIdx = 0;
		int secondIdx = 0;
		int idxGap = 0;
		
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			int side = sc.nextInt();
			sides[i] = side;
			if (sides[i] > sides[firstIdx]) firstIdx = i;
		}
		
		if (sides[(firstIdx-1+6)%6] > sides[(firstIdx+1)%6]) {
			secondIdx = (firstIdx-1+6)%6;
			idxGap = 1;
		}
		else {
			secondIdx = (firstIdx+1)%6;
			idxGap = -1;
		}
		
		int insideIdx_1 = (firstIdx+idxGap+idxGap+6) % 6;
		int insideIdx_2 = (insideIdx_1+idxGap+6) % 6;
		
		int large = (sides[firstIdx] * sides[secondIdx]) 
				- (sides[insideIdx_1] * sides[insideIdx_2]);
		
		System.out.println(K*large);
		sc.close();
	}
}
