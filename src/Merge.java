import java.util.Arrays;
import java.util.Queue;

public class Merge {
    private static int[] Array;
    private static int[] Current;
    private static Queue<Boolean> OrderQueue;//MergeQueue now?
    private static Queue<int[]> MergeQueue;
    private static Queue<int[]> MergeCallQueue;


    private static int[] merge(int[] a, int[] l, int[] r, int left, int right) {
        OrderQueue.add(false);
        MergeCallQueue.add(a);

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

        OrderQueue.add(false);
        MergeCallQueue.add(a);
        return a;
    }

    private static int[] mergeSort(int[] a) {
        //a = MergeQueue.remove();
        int n = a.length;
        if (n < 2) {
            return null;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        MergeQueue.add(l);
        OrderQueue.add(true);
        l = mergeSort(l);
        MergeQueue.add(l);
        OrderQueue.add(true);

        MergeQueue.add(r);
        OrderQueue.add(true);
        r = mergeSort(r);
        MergeQueue.add(r);
        OrderQueue.add(true);

        return merge(a, l, r, mid, n - mid);
    }

    private int[] sort(){
        return mergeSort( Array );
    }//Нельзя

    private Boolean sortStep( ){
        if(OrderQueue.isEmpty()) return false;
        if(OrderQueue.remove()){
            Current = MergeQueue.remove();
        }else{
            Current = MergeCallQueue.remove();
        }
        return true;
    }//Нельзя

    public Boolean nextStep( ){
        return sortStep( );
    }//Можно целиком использовать в других классах

    public int[] getCurrent( ){
        return Current;
    }//Можно

    public void clear( ){
        MergeQueue.clear();
        OrderQueue.clear();
        MergeCallQueue.clear();
        Array = null;
        Current = null;
    }//Нельзя

    public void load( int[] LoadArray ){
        clear();
        Array = new int[LoadArray.length];
        System.arraycopy(LoadArray, 0, Array, 0, Array.length);
        sort( );
    }//Можно целиком использовать в других классах

}
