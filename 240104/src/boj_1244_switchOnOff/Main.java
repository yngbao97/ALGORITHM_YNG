package boj_1244_switchOnOff;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int switchCnt = sc.nextInt();  // 스위치 개수 입력
		int[] switches = new int[switchCnt];  // 스위치 개수를 기준으로 배열 생성
		// 스위치 상태 입력
		for (int i = 0; i < switchCnt; i++) {
			switches[i] = sc.nextInt();
		}
		
		int studentCnt = sc.nextInt();  // 학생 수 입력
		// 학생 수 만큼 반복
		for (int i = 0; i < studentCnt; i++) {
			int gender = sc.nextInt();  // 성별 입력
			int num = sc.nextInt();  // 받은 수 입력
			
			// 남학생일 경우
			if(gender == 1) {
				// 스위치를 처음부터 끝까지 순회하면서
				for (int j = 0; j < switchCnt; j++) {
					// 스위치 번호가 받은 수의 배수이면
					if ((j+1) % num == 0) {
						// 스위치 상태 변환
						if (switches[j] == 0) switches[j] = 1;
						else if (switches[j] == 1) switches[j] = 0;
					}
				}
			} 
			
			// 여학생일 경우
			else if(gender == 2) {
				int mvCnt = 0; // 대칭의 길이
				// 대칭을 확인함으로 전체 스위치 개수의 1/2 미만이 확인해야할 최대 길이이다.
				// 반복되는 만큼 델타값을 증가시키기 위해 j=1부터 시작한다.
				for (int j = 1; j <= switchCnt/2; j++) {
					
					// 실제 배열 인덱스는 0부터 임으로 기준은 num-1
					int fIdx = (num-1) + (-1*j);  // 앞으로 j칸
					int bIdx = (num-1) + (1*j);  // 뒤로 j칸
					
					if (fIdx >= 0 && bIdx < switchCnt) {
						// 앞 인덱스와 뒤 인덱스의 상태가 같으면 대칭 인정
						if (switches[fIdx] == switches[bIdx]) mvCnt++;
						else break; // 다르다면 더이상 대칭이 아님으로 순회 종료
					}
					
				}
				
				// 인정된 길이만큼 시작점과 끝점으로 범위 설정하여 반복
				for (int j = (num-1)-mvCnt; j <= (num-1)+mvCnt; j++) {
					// 스위치 상태 변환
					if (switches[j] == 0) switches[j] = 1;
					else if (switches[j] == 1) switches[j] = 0;
				}
			}
		}
		// 스위치는 한 줄에 최대 20개까지만 출력한다. 초과시 줄바꿈
		for (int i = 0; i < switchCnt; i++) {
			if ((i+1) % 20 == 0) System.out.println(switches[i]);
			else System.out.printf("%d ",switches[i]);
		}
		sc.close();
	}
}
