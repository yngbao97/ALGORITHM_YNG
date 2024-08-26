package boj_2613_숫자구슬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int N;
    static int M;
    static int[] marbles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        marbles = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }

        // Binary search bounds
        int low = Arrays.stream(marbles).max().orElse(0);
        int high = Arrays.stream(marbles).sum();

        int optimalMaxSum = binarySearch(low, high);

        System.out.println(optimalMaxSum);
        printGroupSizes(optimalMaxSum);
        br.close();
    }

    private static int binarySearch(int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (canDivide(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canDivide(int maxSum) {
        int groupCount = 1;
        int currentSum = 0;

        for (int marble : marbles) {
            if (currentSum + marble > maxSum) {
                groupCount++;
                currentSum = marble;
                if (groupCount > M) return false;
            } else {
                currentSum += marble;
            }
        }
        return groupCount <= M;
    }

    private static void printGroupSizes(int maxSum) {
        int currentSum = 0;
        int count = 0;
        int[] groupSizes = new int[M];
        int groupIndex = 0;

        for (int marble : marbles) {
            if (currentSum + marble > maxSum) {
                groupSizes[groupIndex++] = count;
                currentSum = marble;
                count = 1;
            } else {
                currentSum += marble;
                count++;
            }
        }
        groupSizes[groupIndex] = count;

        // Output the result
        for (int i = 0; i < M; i++) {
            System.out.print(groupSizes[i] + " ");
        }
        System.out.println();
    }
}
