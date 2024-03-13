package boj_1874_스택수열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		boolean possible = true;
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		List<Character> answer = new ArrayList<>();
		int idx = 0;
		int num = 1;
		
		while (idx < N) {
			
			if (stack.isEmpty() || stack.peek() < nums[idx]) {
				stack.push(num++);
				answer.add('+');
				
			} else if (stack.peek() == nums[idx]) {
				stack.pop();
				idx++;
				answer.add('-');
				
			} else if (stack.peek() > nums[idx]) {
				possible = false;
				break;
			}
		}
		
		if (possible) {
			for (char c : answer) {
				System.out.println(c);
			}
			
		} else {
			System.out.println("NO");
		}
		
		sc.close();
	}
}