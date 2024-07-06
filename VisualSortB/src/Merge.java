import java.util.Arrays;
import java.util.ArrayList;

public class Merge {
    private static int[] Arrayv;
    private static int[] Current;
    private static ArrayList<String> Stats_12;
    private static ArrayList<int[]> Arrays_12;
    private static ArrayList<Boolean[]> Dusked_12;
    private static Boolean[] template_12;

    public ArrayList<String> getStats( ){
        return Stats_12;
    }

    public ArrayList<int[]> getArrays( ){
        return Arrays_12;
    }

    public ArrayList<Boolean[]> getDusked( ){
        return Dusked_12;
    }

    private static void mergeSort(int[] array, int left, int right, Boolean[] curDusk, int[] data_12 ) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            Boolean[] tempL = new Boolean[template_12.length];
            Boolean[] tempD = new Boolean[template_12.length];
            Boolean[] tempV = new Boolean[template_12.length];
            Boolean[] tempR = new Boolean[template_12.length];
            for( int i = 0; i < template_12.length; ++ i ){
                tempL[i] = template_12[i];
                tempD[i] = curDusk[i];
                tempV[i] = curDusk[i];
                tempR[i] = template_12[i];
            }
            int [] temp7 = new int[array.length];
            for( int i = 0; i < temp7.length; ++ i ) temp7[i] = array[i];
            int [] temp75 = new int[array.length];
            for( int i = 0; i < temp75.length; ++ i ) if(curDusk[i]==false) temp75[i] = array[i];
            Arrays_12.add(temp7);
            Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Dividing: " + Arrays.toString(data_12) + " at: " + mid + " ");
            Dusked_12.add(tempD);
            for( int i = left; i <= mid; ++ i ){
                tempL[i] = false;
            }
            int [] temp8 = new int[array.length];
            for(int i = 0; i < temp8.length; ++ i ) temp8[i] = array[i];
            Arrays_12.add(temp8);
            int [] temp85 = new int[array.length];
            for(int i = 0; i < temp85.length; ++ i ) if(tempL[i]==false) temp85[i] = data_12[i];
            int[] temp11 = new int[mid - left + 1];
            for( int i = 0; i < temp11.length; ++ i ){
                temp11[i] = array[left + i];
            }
            Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Divided-Left: " + Arrays.toString(data_12) + " at: " + mid + " : " + Arrays.toString(temp11));
            Boolean[] tempL_e = new Boolean[tempL.length];
            for( int i = 0; i < tempL.length; ++ i ) tempL_e[i] = tempL[i];
            Dusked_12.add(tempL_e);
            mergeSort(array, left, mid, tempL, temp85);
            for( int i = left; i <= mid; ++ i ){
                tempL[i] = true;
            }
            Boolean[] tempR_e = new Boolean[tempL.length];
            for( int i = 0; i < tempL.length; ++ i ) tempR_e[i] = tempL[i];
            for( int i = mid + 1; i <= right; ++ i ){
                tempR[i] = false;
            }
            int [] temp9 = new int[array.length];
            for(int i = 0; i < temp9.length; ++ i ) temp9[i] = array[i];
            Arrays_12.add(temp9);
            int [] temp95 = new int[array.length];
            for(int i = 0; i < temp95.length; ++ i ) if(tempR[i]==false) temp95[i] = data_12[i];
            int[] temp12 = new int[right - (mid + 1) + 1];
            for( int i = 0; i < temp12.length; ++ i ){
                temp12[i] = array[mid + 1 + i];
            }
            Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Divided-Right: " + Arrays.toString(data_12) + " at: " + mid + " : " + Arrays.toString(temp12));
            Dusked_12.add(tempR_e);
            mergeSort(array, mid + 1, right, tempR, temp95);
            for( int i = mid + 1; i <= right; ++ i ){
                tempR[i] = true;
            }
            int [] temp4 = new int[array.length];
            for(int i = 0; i < temp4.length; ++ i ) temp4[i] = array[i];
            Arrays_12.add(temp4);
            Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Re-Merging: " + Arrays.toString(data_12) + " previously Divided at: " + mid + " ");
            Dusked_12.add(tempV);
            merge(array, left, mid, right);
            int [] temp99 = new int[array.length];
            for(int i = 0; i < temp99.length; ++ i ) temp99[i] = array[i];
            Arrays_12.add(temp99);
            Stats_12.add("Step-" + Stats_12.size() / 1 + " Merge sort: Re-Merged: " + Arrays.toString(data_12) + " previously Divided at: " + mid + " ");
            Dusked_12.add(curDusk);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void launch(){
        System.out.println("Merge Sort Launched");
        //System.out.println(Arrays.toString(mergeSort( Array )));
        Boolean[] template_12_rev = new Boolean[template_12.length];
        for( int i = 0; i < template_12.length; ++ i ) template_12_rev[i] = !template_12[i];
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array received: " + Arrays.toString(Arrayv));
        int [] temp8 = new int[Arrayv.length];
        for( int i = 0; i < temp8.length; ++ i ) temp8[i] = Arrayv[i];
        Arrays_12.add(temp8);
        Dusked_12.add( template_12_rev );
        Boolean[] template_12_1 = new Boolean[template_12.length];
        for( int i = 0; i < template_12_1.length; ++ i ) template_12_1[i] = template_12[i];
        int[] data_12 = new int[Arrayv.length];
        for( int i = 0; i < data_12.length; ++ i ) data_12[i] = Arrayv[i];
        mergeSort(Arrayv, 0, Arrayv.length - 1, template_12_1, data_12);
        Stats_12.add("Step-" + Stats_12.size() / 1 + " Array sorted: " + Arrays.toString(Arrayv));
        int [] temp7 = new int[Arrayv.length];
        for( int i = 0; i < temp7.length; ++ i ) temp7[i] = Arrayv[i];
        Arrays_12.add(temp7);
        Dusked_12.add( template_12_rev );
    }//Нельзя

    public int[] getCurrent( ){
        return Current;
    }//Можно

    public void clear( ){
        if( Arrays_12!=null ) Arrays_12.clear();
        if( Stats_12!=null ) Stats_12.clear();
        if(Arrayv != null) Arrayv = null;
        if(Current != null)Current = null;
        if( template_12 != null ) template_12 = null;
        if( Dusked_12 != null ) Dusked_12 = null;
    }//Нельзя

    public void load( int[] LoadArray ){
        clear();
        template_12 = new Boolean[LoadArray.length];
        for( int i = 0; i < LoadArray.length; ++ i ) template_12[i] = true;
        Arrayv = new int[LoadArray.length];
        Stats_12 = new ArrayList<>();
        Dusked_12 = new ArrayList<>();
        Arrays_12 = new ArrayList<>();
        System.arraycopy(LoadArray, 0, Arrayv, 0, Arrayv.length);
        launch( );
    }//Можно целиком использовать в других классах

}
