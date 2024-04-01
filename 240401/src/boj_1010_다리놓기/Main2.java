/*
 * 도형쓰 풀이
 */

package boj_1010_다리놓기;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {

	static int answer;
    static int N;
    static int M;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            answer = 0;
            
            N = sc.nextInt();
            M = sc.nextInt();
            
            DP(1,1,0);
            System.out.println(answer);
        }
    }  
    
    public static void DP(int i, int last, int numBuilt) {
        
        if (numBuilt == N) {
            answer++;
            return;
        }
        if (i > M || last>N) return;
        
        DP(i+1,last+1,numBuilt+1); // 지어
        DP(i+1,last,numBuilt); // 안짓고 넘어가
        
        
        
        
        
        
        
    }

}
