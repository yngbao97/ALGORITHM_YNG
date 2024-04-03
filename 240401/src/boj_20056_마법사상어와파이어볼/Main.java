package boj_20056_마법사상어와파이어볼;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static int M;
	static int K;
	static List<int[]>[][] map;
	static boolean[] moved;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); 		// 격자 크기
		M = sc.nextInt();		// 파이어볼 개수
		K = sc.nextInt();		// 명령 횟수
		
		map = new ArrayList[N][N];	// 각 칸에 있는 파이어볼 정보
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			map[r][c].add(new int[] {r, c, m, s, d});
		}
		
		for (int i = 0; i < K; i++) {
			move();
			bomb();
		}
		
		int answer = cal();
		System.out.println(answer);
		sc.close();
	}
	
	private static int cal() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null && map[i][j].size() > 0) {
					for (int[] balls : map[i][j]) {
						sum += balls[2];
					}
				}
			}
		}
		return sum;
	}

	private static void bomb() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 1) {
					int cnt = 0;
					int m = 0;
					int s = 0;
					for (int[] ball : map[i][j]) {
						m += ball[2];
						s += ball[3];
						if (ball[4] % 2 != 0) cnt++;
					}
					m /= 5;
					s /= map[i][j].size();
					boolean allSame = false;
					if (cnt == map[i][j].size() || cnt == 0) allSame = true;

					map[i][j].clear();
					
					if (m != 0) {
						
						if (allSame) {
							for (int k = 0; k <= 6; k+=2) {
								map[i][j].add(new int[] {i, j, m, s, k});
							}
						} else {
							for (int k = 1; k <= 7; k+=2) {
								map[i][j].add(new int[] {i, j, m, s, k});
							}
						}
					}
				}
			}
		}
	}

	private static void move() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null && map[i][j].size() > 0) {
					
					for (int[] balls : map[i][j]) {
						int d = balls[4];
						int s = balls[3];
						
						balls[0] = (i + (dr[d] * (s%N)) + N) % N;
						balls[1] = (j + (dc[d] * (s%N)) + N) % N;
						
						// 아직 진짜 옮기진 않고 좌표정보만 갱신해줌
						// 여기서 옮겨두면 다른 칸 돌때 또 옮길수도 있음
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null && map[i][j].size() > 0) {
					
					/// 거꾸로 돌아야 삭제시 인덱스 에러가 안남
					for (int k = map[i][j].size()-1; k >= 0; k--) {
						
						int r = map[i][j].get(k)[0];
						int c = map[i][j].get(k)[1];
						
						if (r != i || c != j) {
							map[r][c].add(map[i][j].get(k));
							map[i][j].remove(k);
						}
					}
				}
			}
		}
	}
}
