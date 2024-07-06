import java.util.ArrayList;
import java.util.Arrays;

public class Insertion {
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

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            Stats_12.add("Step-" + Stats_12.size() / 1 + " First Position selected: " + i + " ");
            int [] temp8 = new int[array.length];
            for( int j = 0; j < temp8.length; ++ j ) temp8[j] = array[j];
            Arrays_12.add(temp8);
            for (int j = i; j > 0; --j) {
                Stats_12.add("Step-" + Stats_12.size() / 1 + " Second Position selected: " + j + " ");
                int [] temp9 = new int[array.length];
                for( int k = 0; k < temp9.length; ++ k ) temp9[k] = array[k];
                Arrays_12.add(temp9);
                if (array[j] < array[j-1]) {
                    Stats_12.add("Step-" + Stats_12.size() / 1 + " Swapping: A[" + i + "] = " + array[i] + " with: A[" + j + "] = " + array[j]);
                    int [] temp10 = new int[array.length];
                    for( int k = 0; k < temp10.length; ++ k ) temp10[k] = array[k];
                    Arrays_12.add(temp10);
                    swap(array, j, j-1);
                    Stats_12.add("Step-" + Stats_12.size() / 1 + " Swapped: A[" + i + "] = " + array[i] + " with: A[" + j + "] = " + array[j]);
                    int [] temp11 = new int[array.length];
                    for( int k = 0; k < temp11.length; ++ k ) temp11[k] = array[k];
                    Arrays_12.add(temp11);
                } else {
                    Stats_12.add("Step-" + Stats_12.size() / 1 + " Stop: no reason to keep current First Position");
                    int [] temp10 = new int[array.length];
                    for( int k = 0; k < temp10.length; ++ k ) temp10[k] = array[k];
                    Arrays_12.add(temp10);
                    break;
                }
            }
        }
        return array;
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

        System.out.println("Insertion Sort Launched");
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