import java.util.*;

public class Heap4_Nearest_k_Cars {
    static class Point implements Comparable<Point> {
        int x, y, DistSq, idx;

        public Point(int X, int Y, int DSQ, int IDX) {
            this.x = X;
            this.y = Y;
            this.idx = IDX;
            this.DistSq = DSQ;
        }

        @Override
        public int compareTo(Point p2) {
            return this.DistSq - p2.DistSq;
        }
    }

    public static void main(String args[]) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int dist[][] = { { 3, 3, 1 }, { 5, -1, 2 }, { -2, 4, 3 } };
        int k = 2;
        for (int i = 0; i < dist.length; i++) {
            int x = dist[i][0];
            int y = dist[i][1];
            int DistSq = (x * x) + (y * y);
            pq.add(new Point(x, y, DistSq, dist[i][2]));
        }
        for (int i = 0; i < k; i++) {
            double Distance = Math.sqrt(pq.peek().DistSq);
            System.out.println("C" + pq.remove().idx + " WITH DISTANCE OF " + (float) Distance + " FROM THE ORIGON");
        }

    }
}
