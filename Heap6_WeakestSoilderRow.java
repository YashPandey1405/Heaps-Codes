import java.util.*;

public class Heap6_WeakestSoilderRow {
    static class Row implements Comparable<Row> {
        int Soilder;
        int idx;

        public Row(int SOILDER, int IDX) {
            this.Soilder = SOILDER;
            this.idx = IDX;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.Soilder == r2.Soilder) {
                return this.idx - r2.idx;
            }
            return this.Soilder - r2.Soilder;
        }
    }

    public static void main(String args[]) {
        int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int SoilderCount = 0;
            for (int j = 0; j < army[0].length; j++) {
                if (army[i][j] == 1) {
                    SoilderCount++;
                }
            }
            pq.add(new Row(SoilderCount, i));
        }
        for (int i = 0; i < k; i++) {
            int index = pq.peek().idx;
            System.out.println("ROW-" + index + " WITH " + pq.peek().Soilder + " SOLIDERS AT INDEX " + index);
            pq.remove();
        }
    }
}
