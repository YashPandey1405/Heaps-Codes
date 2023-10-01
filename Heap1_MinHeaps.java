import java.util.*;

public class Heap1_MinHeaps {
    static class MinHeap {
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) { // O(Logn)......
            list.add(data);
            int Child_IDX = (list.size()) - 1;
            int Parent_IDX = (Child_IDX - 1) / 2;
            while (list.get(Child_IDX) < list.get(Parent_IDX)) { // O(Logn)......
                int temp = list.get(Child_IDX); // Swap...
                list.set(Child_IDX, list.get(Parent_IDX));
                list.set(Parent_IDX, temp);
                Child_IDX = Parent_IDX;
                Parent_IDX = (Child_IDX - 1) / 2;
            }
        }

        public int peek() { // O(1)......
            return list.get(0);
        }

        private void heapify(int i) { // O(Logn).....
            int Left = (2 * i) + 1;
            int Right = (2 * i) + 2;
            int MinIDX = i;
            if (Left < list.size() && list.get(MinIDX) > list.get(Left)) {
                MinIDX = Left;
            }
            if (Right < list.size() && list.get(MinIDX) > list.get(Right)) {
                MinIDX = Right;
            }
            if (MinIDX != i) {
                int temp = list.get(i);
                list.set(i, list.get(MinIDX));
                list.set(MinIDX, temp);
                heapify(MinIDX);
            }
        }

        public int remove() { // O(Logn).....
            int data = list.get(0);
            int n = list.size() - 1;

            // Step-1 ::: Swap The First & Last Element Of The ArrayList.....
            int temp = list.get(0);
            list.set(0, list.get(n));
            list.set(n, temp);

            // Step-2 ::: Delete The Last Element Of The ArrayList.....
            list.remove(n);

            // Step-3 ::: Heapify To Mantain/Fix The MinHeap.....
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main(String args[]) {
        MinHeap h = new MinHeap();
        h.add(1);
        h.add(5);
        h.add(3);
        h.add(2);
        h.add(4);
        System.out.print("THE MIN-HEAP IS ::: ");
        while (!h.isEmpty()) { // Heap Sort.....
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
