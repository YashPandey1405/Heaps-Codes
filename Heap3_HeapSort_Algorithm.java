public class Heap3_HeapSort_Algorithm {

    public static void heapify_AscendOrder(int arr[], int i, int size) { // O(Logn)........
        int Left = (2 * i) + 1;
        int Right = (2 * i) + 2;
        int MaxIDX = i;
        if (Left < size && arr[Left] > arr[MaxIDX]) {
            MaxIDX = Left;
        }
        if (Right < size && arr[Right] > arr[MaxIDX]) {
            MaxIDX = Right;
        }
        if (MaxIDX != i) {
            int temp = arr[i];
            arr[i] = arr[MaxIDX];
            arr[MaxIDX] = temp;
            heapify_AscendOrder(arr, MaxIDX, size);
        }
    }

    public static void HeapSort_AscendOrder(int arr[]) { // O(nLogn).......
        // Step 1 ::: Build MaxHeap.....
        int n = arr.length;
        for (int i = (n / 2); i >= 0; i--) {
            heapify_AscendOrder(arr, i, n);
        }

        // Step 2 ::: Push Largest At End.....
        for (int i = (n - 1); i > 0; i--) {
            // Swap --> (First<-->Last).....
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify_AscendOrder(arr, 0, i);
        }
    }

    public static void AscendingOrder(int arr[]) {
        int n = arr.length;
        HeapSort_AscendOrder(arr); // O(nLogn).......
        System.out.print("By Heap Sort ::: ASCENDING SORTED ARRAY FROM THE ARRAY {1,2,4,5,3} IS ::: { ");
        for (int i = 0; i < n; i++) {
            if (i == (n - 1)) {
                System.out.println(arr[i] + " }");
            } else {
                System.out.print(arr[i] + " , ");
            }
        }
    }

    public static void heapify_DesendOrder(int arr[], int i, int size) { // O(Logn)....
        int Left = (2 * i) + 1;
        int Right = (2 * i) + 2;
        int MinIDX = i;
        if (Left < size && arr[Left] < arr[MinIDX]) {
            MinIDX = Left;
        }
        if (Right < size && arr[Right] < arr[MinIDX]) {
            MinIDX = Right;
        }
        if (MinIDX != i) {
            int temp = arr[i];
            arr[i] = arr[MinIDX];
            arr[MinIDX] = temp;
            heapify_AscendOrder(arr, MinIDX, size);
        }
    }

    public static void HeapSort_DesendOrder(int arr[]) { // O(nLogn).......
        // Step 1 ::: Build MinHeap.....
        int n = arr.length;
        for (int i = (n / 2); i >= 0; i--) {
            heapify_DesendOrder(arr, i, n);
        }

        // Step 2 ::: Push Largest At End.....
        for (int i = (n - 1); i > 0; i--) {
            // Swap --> (First<-->Last).....
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify_DesendOrder(arr, 0, i);
        }
    }

    public static void DesendingOrder(int arr[]) {
        int n = arr.length;
        HeapSort_DesendOrder(arr); // O(nLogn).......
        System.out.print("By Heap Sort ::: DESENDING SORTED ARRAY FROM THE ARRAY {1,2,4,5,3} IS ::: { ");
        for (int i = 0; i < n; i++) {
            if (i == (n - 1)) {
                System.out.println(arr[i] + " }");
            } else {
                System.out.print(arr[i] + " , ");
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3 };
        AscendingOrder(arr); // For Ascending Sorting Of The Array....
        DesendingOrder(arr); // For Desending Sorting Of The Array....
    }
}
