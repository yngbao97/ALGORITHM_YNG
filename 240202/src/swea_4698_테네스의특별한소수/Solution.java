package swea_4698_테네스의특별한소수;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("src/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		boolean[] notPrime = new boolean[1000000+1];
		notPrime[0] = true;
		notPrime[1] = true;
		for (int i = 2; i <= 1000+1; i++) {
			if (!notPrime[i]) {
				for (int j = i+i; j <= 1000000; j+=i) {
					if (notPrime[j]!=true && j%i == 0) notPrime[j] = true;
				}
			}
		}
		
		
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			boolean[] isSpecial = new boolean[B+1];
			
			for (int i = A; i <= B; i++) {
				int num = i;
				while (num != 0) { // num/3 != 0 으로 했었는데 살짝 오차 생김. 왜지?
					if(num%10 == D) {
						isSpecial[i] = true;
						break;
					}
					num /= 10;
				}
			}
			
			int ans = 0;
			for (int i = A; i<=B; i++) {
				if (!notPrime[i] && isSpecial[i]) ans++;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
