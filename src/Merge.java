import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;

public class Merge {
    private static int[] Arrayv;
    private static int[] Current;
    private static ArrayList<String> Stats_12;
    private static ArrayList<int[]> Arrays_12;

    public ArrayList<String> getStats( ){
        return Stats_12;
    }

    public ArrayList<int[]> getArrays( ){
        return Arrays_12;
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        //if( l == null ) l = new int[0];
        //if( r == null ) r = new int[0];
        String temp = "Merge sort: Merging: ";
        temp += Arrays.toString(l);
        temp += " and: ";
        temp += Arrays.toString(r);
        Stats_12.add("Step-" + Stats_12.size() / 1 + " " +temp );
        int[] temp3 = new int[l.length+r.length];
        int temp4 = 0;
        for( ; temp4 < l.length; ++ temp4 ){
            temp3[temp4] = l[temp4];
        }
        for( ; temp4 < l.length + r.length; ++ temp4 ){
            temp3[temp4] = r[temp4 - l.length];
        }
        Arrays_12.add(temp3);

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

        temp = "Merge Sort: Merged into: ";
        temp += Arrays.toString(a);
        Stats_12.add("Step-" + Stats_12.size() / 1 + " " + temp );
        int [] temp5 = new int[a.length];
        for( temp4 = 0; temp4 < a.length; ++ temp4 ) temp5[temp4] = a[temp4];
        Arrays_12.add(temp5);
        return;
    }

    private static void mergeSort(int[] a) {
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Dividing: " + Arrays.toString(a));
        int [] temp7 = new int[a.length];
        for( int i = 0; i < temp7.length; ++ i ) temp7[i] = a[i];
        Arrays_12.add(temp7);
        int n = a.length;
        if (n < 2) {
            return;
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

        Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Divided: " + Arrays.toString(a)+" into " + Arrays.toString(l) + " and " + Arrays.toString(r));
        int [] temp8 = new int[a.length];
        for( int i = 0; i < temp8.length; ++ i ) temp8[i] = a[i];
        Arrays_12.add(temp8);
        mergeSort(l);
        mergeSort(r);

        merge(a, l, r, mid, n - mid);
    }

    private void launch(){
        System.out.println("Merge Sort Launched");
        //System.out.println(Arrays.toString(mergeSort( Array )));
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array received: " + Arrays.toString(Arrayv));
        int [] temp8 = new int[Arrayv.length];
        for( int i = 0; i < temp8.length; ++ i ) temp8[i] = Arrayv[i];
        Arrays_12.add(temp8);
        mergeSort(Arrayv);
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array sorted: " + Arrays.toString(Arrayv));
        int [] temp7 = new int[Arrayv.length];
        for( int i = 0; i < temp7.length; ++ i ) temp7[i] = Arrayv[i];
        Arrays_12.add(temp7);
    }//Нельзя

    public int[] getCurrent( ){
        return Current;
    }//Можно

    public void clear( ){
        if( Arrays_12!=null ) Arrays_12.clear();
        if( Stats_12!=null ) Stats_12.clear();
        if(Arrayv != null) Arrayv = null;
        if(Current != null)Current = null;
    }//Нельзя

    public void load( int[] LoadArray ){
        clear();
        Arrayv = new int[LoadArray.length];
        Stats_12 = new ArrayList<>();
        Arrays_12 = new ArrayList<>();
        System.arraycopy(LoadArray, 0, Arrayv, 0, Arrayv.length);
        launch( );
    }//Можно целиком использовать в других классах

}
