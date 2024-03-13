package boj_1436_영화감독숌;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num = 666;
		int cnt = 1;
		
		// 카운트가 N보다 작으면 반복
		while (cnt != N) {
			
			// num을 하나씩 늘리면서 확인해
			num++;
			
			// 666이 포함되어있는지, 포함되어 있다면 하나 찾았으니까 cnt++
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
		sc.close();
	}
}