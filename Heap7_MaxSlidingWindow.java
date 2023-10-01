import java.util.*;

public class Heap7_MaxSlidingWindow {
    static class Pair implements Comparable<Pair> { // O(nLogk).....
        int Value;
        int idx;

        public Pair(int Value, int idx) {
            this.Value = Value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // For Ascending Sorting Of The Pair Class Objects....
            // return this.Value-p2.Value;
            return p2.Value - this.Value; // For Desending Sorting Of The Pair Class Objects....
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3, n = arr.length;
        int ans[] = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        ans[0] = pq.peek().Value;
        for (int i = k; i < n; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            ans[i - k + 1] = pq.peek().Value;
        }
        for (int i = 0; i < ans.length; i++) { // Loop To Print The Max. Window.....
            System.out.print(ans[i] + " ");
        }
    }
}
