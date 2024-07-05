package swea_5653_줄기세포배양;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/swea_5653_줄기세포배양/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int K = sc.nextInt();
			
			int N = n + K +2;
			int M = m + K +2;
			Cell[][] field = new Cell[N][M];
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			// 번식가능한 만큼 넓힌 영역 정가운데 입력
			for (int i = K/2+1; i < n+K/2+1; i++) {
				for (int j = K/2+1; j < m+K/2+1; j++) {
					int life = sc.nextInt();
					field[i][j] = new Cell(life, life);
					if (life != 0) {
						queue.add(new int[] {i, j});
						visited[i][j] = true;
					}
				}
			}
			
//			print();
			
			for (int time = 1; time <= K; time++) {
				int cnt = queue.size();
				
				for (int qCnt = 0; qCnt < cnt; qCnt++) {
					
					int[] curr = queue.poll();
					int r = curr[0];
					int c = curr[1];
					
					Cell currCell = field[r][c];
					
					
					if (currCell.cnt == 0) {
						
						if (currCell.x != 1) {
							currCell.cnt--;
							queue.add(new int[] {r, c});
						}
						// 번식, 번식한 위치 큐에 추가
						
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							 
							if (!visited[nr][nc]) {
								if(field[nr][nc] == null || field[nr][nc].x == 0) {
									field[nr][nc] = new Cell(currCell.x, currCell.x);
									queue.add(new int[] {nr, nc});
								} else {
									Cell compare = field[nr][nc];
									if (!visited[nr][nc] && compare.x < currCell.x) {
										compare.x = compare.cnt = currCell.x;
									}
								}
							}
						
						}
						
					} else if (currCell.cnt > 0) {
						// 생명력 -1, 큐에 위치 다시 추가
						currCell.cnt--;
						queue.add(new int[] {r, c});
						
//						System.out.println("생명력 감소 : "+ currCell);
					}
					
					if (currCell.cnt < 0 && currCell.cnt > -currCell.x) {
						currCell.cnt--;
						queue.add(new int[] {r, c});
					}
				}
				
				int setCnt = queue.size();
				for (int c = 0; c < setCnt; c++) {
					int[] curr = queue.poll();
					visited[curr[0]][curr[1]] = true;
					queue.add(curr);
				}
			}
			
			int answer = queue.size();
			System.out.printf("#%d %d\n", tc, answer);
			
		}
		sc.close();
	}
}

class Cell {
	int x;
	int cnt;
	
	Cell(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Cell [x=" + x + ", cnt=" + cnt + "]";
	}
	
}
