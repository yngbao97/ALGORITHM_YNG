import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		boolean[][] visited = new boolean[2000][2000];
		
		Queue<Status> queue = new ArrayDeque<>();
		queue.add(new Status(1, 0, 0));
		visited[1][0] = true;
		int cnt = 1;
		int answer = 0;
		
		out: while (!queue.isEmpty()) {
			int repeat = cnt;
			cnt = 0;
			for (int i = 0; i < repeat; i++) {
				Status s = queue.poll();
				
				if (s.num == S) {
					answer = s.calCnt;
					break out;
				}
				
				
				// 복사
				if (!visited[s.num][s.num]) {
					queue.add(new Status(s.num, s.calCnt + 1, s.num));
					visited[s.num][s.num] = true;
					cnt++;
				}
				
				// 붙여넣기
				if (s.clipboard != 0 && s.num + s.clipboard < 2000
						&& !visited[s.num + s.clipboard][s.clipboard]) {
					queue.add(new Status(s.num + s.clipboard, s.calCnt + 1, s.clipboard));
					visited[s.num + s.clipboard][s.clipboard] = true;
					cnt++;
				}
				
				// -1
				if (s.num - 1 > 0 &&!visited[s.num - 1][s.clipboard]) {
					queue.add(new Status(s.num - 1, s.calCnt + 1, s.clipboard));
					visited[s.num - 1][s.clipboard] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}

class Status {
	int num;
	int calCnt;
	int clipboard;
	
	Status (int num, int calCnt, int clipboard) {
		this.num = num;
		this.calCnt = calCnt;
		this.clipboard = clipboard;
	}
}