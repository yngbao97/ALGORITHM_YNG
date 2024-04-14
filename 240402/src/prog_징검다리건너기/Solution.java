package prog_징검다리건너기;

class Solution {
	
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int answer = solution(stones, k);
		
		System.out.println(answer);
	}
	
    public static int solution(int[] stones, int k) {
        return bs(stones, 1, 200_000_000, k);
    }

	private static int bs(int[] stones, int st, int ed, int k) {
		
		if (st > ed) return ed;
		
		int mid = (st + ed) / 2;
		
		if (canCross(stones, mid, k)) {
			return bs(stones, mid+1, ed, k);
		} else return bs(stones, st, mid-1, k);

	}

	private static boolean canCross(int[] stones, int mid, int k) {
		
		int cnt = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] - mid < 0) {
				cnt++;
				if (cnt >= k) return false;
			} else {
				cnt = 0;
			}
		}
		return true;
	}

}
