package boj_1676_팩토리얼0의개수;

import java.util.Scanner;
/*
 * 주어지는 N의 값이 너무 커서 자료형에 오류가 생긴다.
 * BigInteger 써줘야함. 근데 그렇게까지? 라고 생각해서 찾아봤다.
 * 
 * 알고리즘 원리:
 * 뒷자리에 0이 나올때는 2와 5가 곱해져있을 때다. => 10
 * 두 수의 제곱이 짝지어지는 수만큼 0이 있는 건데,
 * 팩토리얼을 소인수 분해를 했을 때 2가 5보다 작은수여서 당연히 제곱이 많다.
 * 따라서 5의 개수에 따라 0의 개수가 정해진다고 보면 된다.
 * 
 * 팩토리얼 소인수분해 => 곱하는 각 수의 약수들
 * 5의 배수일때만 5가 들어가기 때문에 팩토리얼 과정 안에 5의 배수가 몇번 곱해지는지 보면된다.
 * 5, 10, 15, 20, 25 ... 주의할 점은 25는 5*5 이므로 제곱이 두개만큼 늘어난다.
 * 그래서 방법은 5로 더이상 나누어 지지 않을 때까지 나눠가면서 몫을 더하는 것!
 * 
 * <참고 링크>
 * https://st-lab.tistory.com/165
 */
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		
		System.out.println(count);
		sc.close();
	}
}