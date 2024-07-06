import java.util.ArrayList;
import java.util.Arrays;

public class Bubble {
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

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            Stats_12.add("Step-" + Stats_12.size() / 1 + " First Position selected: " + i + " ");
            int [] temp8 = new int[arr.length];
            for( int j = 0; j < temp8.length; ++ j ) temp8[j] = arr[j];
            Arrays_12.add(temp8);
            for (int j = 0; j < n-i-1; j++) {
                Stats_12.add("Step-" + Stats_12.size() / 1 + " Second Position selected: " + j + " ");
                int [] temp9 = new int[arr.length];
                for( int k = 0; k < temp9.length; ++ k ) temp9[k] = arr[k];
                Arrays_12.add(temp9);
                if (arr[j] > arr[j+1]) {
                    Stats_12.add("Step-" + Stats_12.size() / 1 + " Swapping: A[" + i + "] = " + arr[i] + " with: A[" + j + "] = " + arr[j]);
                    int [] temp10 = new int[arr.length];
                    for( int k = 0; k < temp10.length; ++ k ) temp10[k] = arr[k];
                    Arrays_12.add(temp10);
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    Stats_12.add("Step-" + Stats_12.size() / 1 + " Swapped: A[" + i + "] = " + arr[i] + " with: A[" + j + "] = " + arr[j]);
                    int [] temp11 = new int[arr.length];
                    for( int k = 0; k < temp11.length; ++ k ) temp11[k] = arr[k];
                    Arrays_12.add(temp11);
                }
            }
        }
    }

    public int[] getCurrent( ){
        return Current;
    }//Можно

    public int[] getArray( ){
        return Arrayv;
    }

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

        System.out.println("Bubble Sort Launched");
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array received: " + Arrays.toString(Arrayv));
        int [] temp8 = new int[Arrayv.length];
        for( int i = 0; i < temp8.length; ++ i ) temp8[i] = Arrayv[i];
        Arrays_12.add(temp8);
        sort( Arrayv );
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array sorted: " + Arrays.toString(Arrayv));
        int [] temp7 = new int[Arrayv.length];
        for( int i = 0; i < temp7.length; ++ i ) temp7[i] = Arrayv[i];
        Arrays_12.add(temp7);
    }//Можно целиком использовать в других классах

}