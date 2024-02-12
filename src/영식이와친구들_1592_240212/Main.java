package 영식이와친구들_1592_240212;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int member = sc.nextInt();
		int limit = sc.nextInt();
		int passDist = sc.nextInt();
		
		int[] recieve = new int[member];
		int who = 0;
		int throwCnt = 0;
		
		while(true) {
			int cnt = ++recieve[who];
			if (cnt == limit) break;
			else if (cnt%2 == 0) {
				who = ((who - passDist + member) % member);
				throwCnt++;
			} else {
				who = (who + passDist) % member;
				throwCnt++;
			}
		}
		
		System.out.println(throwCnt);
		sc.close();
	}
}
