package aufgaben;

import java.util.Arrays;

//schimb numele clasei
public class Array_2 {

    private int[] arr;

    public Array_2(int[] arr) {
        this.arr = arr;
    }

    //cea mai mare cifra din array
    public int maxZahl(){
        int max = this.arr[0];
        for(int num : this.arr){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    //cea mai mica cifra din array
    public int minZahl(){
        int min = this.arr[0];
        for(int num : this.arr){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    //cea mai mica suma alcatuita din array.lenght-1 elemente
    public int minSumme(){

        int max = maxZahl();
        return Arrays.stream(this.arr).sum()-max;
    }

    //cea mai mare suma alcatuita din array.lenght-1 elemente
    public int maxSumme(){

        int min = minZahl();
        return Arrays.stream(this.arr).sum()-min;
    }

}
