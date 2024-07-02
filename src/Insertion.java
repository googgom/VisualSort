import java.util.Queue;

public class Insertion {
    private static int[] Array;
    private static int[] Current;



    private int[] sort(){
        return Array;//заменить
    }//Нельзя

    private Boolean sortStep( ){
        return false;//заменить
    }//Нельзя

    public Boolean nextStep( ){
        return sortStep( );
    }//Можно целиком использовать в других классах

    public int[] getCurrent( ){
        return Current;
    }//Можно

    public void clear( ){
        //???
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

