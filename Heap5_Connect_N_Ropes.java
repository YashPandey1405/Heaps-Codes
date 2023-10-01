import java.util.*;

public class Heap5_Connect_N_Ropes {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = { 4, 3, 3, 2, 6 };
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() > 1) {
            int Part1 = pq.remove();
            int Part2 = pq.remove();
            sum += (Part1 + Part2);
            pq.add(Part1 + Part2);
        }
        System.out.println("THE MINIMUM COST WILL BE ::: " + sum);
    }
}
