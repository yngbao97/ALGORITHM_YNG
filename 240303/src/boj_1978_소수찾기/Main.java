package boj_1978_소수찾기;

import java.util.Scanner;

/*
 * 비슷한 문제로, swea에 '테네스의 특별한 소수'라는 문제가 있다.
 * 소수 문제는 처음에 범위 안의 숫자들 중 소수인 것들을 미리 판단해놓고 시작하면 좋다.
 * 불린 배열을 사용한다.
 * 
 * 1. 0과 1은 소수가 아니다.
 * 2. 2부터 소수인 경우 그 수로 뒷 숫자들을 다 나눠본다.
 * 3. 아직 소수가 아니라고 판명되지 않았고, 나누어 떨어지는 수는 소수가 아니라고 판단해준다.
 * 4. 한번 소수가 아닌 수로 판단한 수는 다시 판단하지 않는다. (시간 단축)
 * 5. 나누는 수는 소수 여부를 판단해야 하는 최대값의 제곱근이다.(여기까지만 판단하면 다 판단했다고 볼 수 있음 - 에라토스테네스의 채)
 */

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] > max) max = nums[i];
		}
		
		boolean[] not_Prime = new boolean[max+1];
		not_Prime[0] = true;
		not_Prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (!not_Prime[i]) {
				for (int j = i+1; j <= max; j++) {
					if (j%i == 0 && !not_Prime[j]) {
						not_Prime[j] = true;
					}
				}
			}
		}
		
		int answer = 0;
		for (int num : nums) {
			if (!not_Prime[num]) {
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}
