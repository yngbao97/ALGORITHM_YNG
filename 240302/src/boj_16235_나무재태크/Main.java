package boj_16235_나무재태크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

	static int N;
	static int M;
	static int K;
	static int[][] basic;
	static int[][] area;
	static List<Integer>[] trees;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 밭 한변의 길이
		M = sc.nextInt();		// 나무의 개수 
		K = sc.nextInt();		// 문제: K년이 지난 후 나무의 개수
		
		basic = new int[N][N];
		area = new int[N][N];
		trees = new List[N*N];
		
		// 매년 추가될 기본 양분 정보와 실제 땅 양분 동시 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int tmp = sc.nextInt();
				basic[r][c] = tmp;
				area[r][c] = tmp;
			}
		}
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int age = sc.nextInt();
			int idx = N*(r-1)+(c-1);
			if (trees[idx] == null) {
				trees[idx] = new ArrayList<>();
			}
			trees[idx].add(age);
			Collections.sort(trees[idx]);
		}
		
		for (int y = 0; y < K; y++) {
			springSummer();
			autumn();
			winter();
			System.out.println(Arrays.toString(trees));
		}
		
		int answer = count();

		System.out.println(answer);
	}
	
	public static int count() {
		int result = 0;
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] != null) {
				result += trees[i].size();
			}
		}
		return result;
	}

	public static void winter() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				area[r][c] += basic[r][c];
				System.out.print(area[r][c]+" ");
			}
			System.out.println();
		}
	}

	public static void autumn() {
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] != null && trees[i].size() > 0) {
				for (int t = 0; t < trees[i].size(); t++) {
					if (trees[i].get(t) % 5 == 0) {
						int r = i/N;
						int c = i%N;
						for (int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								int idx = N*nr + nc;
								if (trees[idx] == null) {
									trees[idx] = new ArrayList<>();
								}
								trees[idx].add(0, 1);
							}
						}
					}
				}
			}
		}
	}

	public static void springSummer() {
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] != null && trees[i].size() > 0) {
				int plus = 0;
				int r = i/N;
				int c = i%N;
				for (int t = 0; t < trees[i].size(); t++) {
					int tree = trees[i].get(t);
					if (area[r][c] >= tree) {
						area[r][c] -= tree;
						trees[i].set(t, tree+1);
					} else {
						trees[i].remove(t);
						plus += tree/2;
						t--;
					}
				}
				area[r][c] += plus;
			}
		}
	}

}
