import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(64);
        stockSpanner.next(21);

    }
    public int findJudge(int N, int[][] trust) {
        if(N == 1)
            return 1;
        int[] outDegree = new int[N + 1];
        int[] inDegree = new int[N + 1];
        for (int[] ints : trust) {
            int from = ints[0];
            int to = ints[1];
            outDegree[from]++;
            inDegree[to]++;
        }
        for (int i = 0; i <= N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;


    }
}