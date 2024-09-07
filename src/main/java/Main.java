import java.util.Arrays;

public class Main {
    //develop
    static int[] arr = {4, 1, 2, 12, 42, 2, 42, 92};

    static public int[] getSortArray() {
        Arrays.sort(arr);
        return arr;
    }

    static public boolean IsSortedDev(){
        int []_arr = getSortArray();
        for (int i = 1; i < _arr.length; i++){
            if(_arr[i-1] > _arr[i]){
                return false;
            }
        }
        return true;
    }

    static public int findMax(){
        return Arrays.stream(arr).max().getAsInt();
    }

    static public int findMin(){
        return Arrays.stream(arr).min().getAsInt();
    }
}