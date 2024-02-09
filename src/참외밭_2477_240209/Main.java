package 참외밭_2477_240209;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();		// 면적당 참외 개수
		int[] sides = new int[6];
		
		int fullIdx_1 = 0;
		int fullIdx_2 = 0;
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			int side = sc.nextInt();
			sides[i] = side;
			if (sides[i] > sides[fullIdx_1]) fullIdx_1 = i;
		}
		
		if (sides[(fullIdx_1 -1+6)%6] > sides[(fullIdx_1 +1)%6]) {
			fullIdx_2 = (fullIdx_1 - 1+6) % 6;
		} else fullIdx_2 = (fullIdx_1 + 1) % 6;
		
		int idxGap = fullIdx_1 - fullIdx_2;
		if (idxGap == 5 || idxGap == -5) idxGap = 1;
		
		int insideIdx_1 = ((fullIdx_1 + (idxGap*2))+6) % 6;
		int insideIdx_2 = ((insideIdx_1 + idxGap)+6) % 6;
		
		int large = (sides[fullIdx_1] * sides[fullIdx_2])
				- (sides[insideIdx_1] * sides[insideIdx_2]);
		
		System.out.println(K*large);
		sc.close();
	}
}
