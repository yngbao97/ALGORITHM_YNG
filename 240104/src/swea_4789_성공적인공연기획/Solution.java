package swea_4789_성공적인공연기획;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); // BufferedReader로 받으면 String으로 밖에 못받아서 형변환 필수
		
		for(int tc = 1; tc <= T; tc++) {
			int sum = 0; // 카운트 지점까지 일어날 사람 수
			int ans = 0; // 필요한 고용인 수
			
			String input = bf.readLine();
			int[] arr = new int[input.length()];
			for (int i=0;i<input.length();i++) {
				arr[i] = Character.getNumericValue(input.charAt(i));
			}
			
			for (int i = 0; i < arr.length; i++) {
				if (sum >= i) sum+=arr[i];
				else {
					ans+=i-sum;
					sum+=(i-sum)+arr[i];
				}
				
			}
		
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
