package swea_5356_의석이의세로로말해요;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("src/의석이의세로로말해요_5356_240127/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Queue<String>[] qArr = new LinkedList[5];
			for (int r = 0; r < 5; r++) {
				qArr[r] = new LinkedList<String>(Arrays.asList(sc.nextLine().split("")));
			}
			
			System.out.printf("#%d ", tc);
			int cnt = 0;
			while (cnt < 5) {
				for (int r = 0; r < 5; r++) {
					if (!qArr[r].isEmpty()) {
						System.out.print(qArr[r].poll());
						if(qArr[r].isEmpty()) cnt++;
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
