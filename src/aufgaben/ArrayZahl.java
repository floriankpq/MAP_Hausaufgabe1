package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayZahl {

    private int[] zahl;

    public ArrayZahl(int[] zahl) {
        this.zahl = zahl;
    }

    //calculeaza suma dintre this.zahl si some tratandu le ca numere
    //pre: some.length = this.zahl.length & type(some) = int[]
    //post: sum = some + this.zahl
    public int[] sum(ArrayZahl some){

        int[] summed = new int[this.zahl.length];
        int overflow = 0;

        for(int i = this.zahl.length-1; i >= 0; i--){

            if((this.zahl[i] + some.zahl[i])<10){
                summed[i] = this.zahl[i] + some.zahl[i] + overflow;
                overflow = 0;

                if (summed[i] == 10){
                    overflow = 1;
                    summed[i] = 0;
                }

            }
            else{
                summed[i] = (this.zahl[i] + some.zahl[i]) % 10 + overflow;
                overflow = 1;
            }
        }

        if(overflow == 1) {
            int[] summedoverflow = new int[this.zahl.length + 1];
            summedoverflow[0] = 1;
            for (int j = 0; j < this.zahl.length; j++) {
                summedoverflow[j + 1] = summed[j];
            }
            return summedoverflow;
        }
        else
            return summed;
    }

    //calculeaza diferenta dintre this.zahl si some tratandu le ca numere
    //pre: some.length = this.zahl.length & type(some) = int[]
    //post: div = some - this.zahl
    public int[] dif(ArrayZahl some){

        int[] dif = new int[this.zahl.length];
        int number;
        int[] fals = {-1};

        if(this.zahl[0] < some.zahl[0])
            return fals;

        for(int i = 0;i < this.zahl.length; i++){

            number = this.zahl[i] - some.zahl[i];

            if(number < 0){

                int j = i;

                while(number < 0){

                    dif[j-1]--;
                    dif[j] = number + 10;
                    j--;
                    number = dif[j];
                }
            }
            else{
                dif[i] = number;
            }

        }
        int i = 0;
        while(dif[i] == 0 && i < dif.length-1)
            i++;

        if(i==0)
            return dif;
        else{
            int[] shortdif = new int[dif.length-i];
            for(int j = 0; j< shortdif.length; j++){
                shortdif[j] = dif[i];
                i++;
            }
            return shortdif;
        }
    }

    //calculeaza inmultirea dintre this.zahl si x tratand this.zahl ca un pe un numar
    //pre: type(x) = int & 0<=x<=9
    //post: mul = this.zahl*x
    public ArrayList<Integer> mul(int x){

        int number = 0;
        int i = 0;

        while(i < this.zahl.length){
            number = number*10 + this.zahl[i];
            i++;
        }

        number *= x;

        ArrayList<Integer> mul = new ArrayList<Integer>();

        while(number != 0){
            mul.add(number%10);
            number /= 10;
        }

        Collections.reverse(mul);
        return mul;

    }

    //calculeaza impartirea dintre this.zahl si x tratand this.zahl ca un pe un numar
    //pre: type(x) = int & 1<=x<=9
    //post: div = this.zahl/x
    public ArrayList<Integer> div(int teiler){

        int number = 0;
        int i = 0;

        while(i < this.zahl.length){
            number = number*10 + this.zahl[i];
            i++;
        }

        number = number/teiler;

        ArrayList<Integer> div = new ArrayList<Integer>();

        while(number != 0){
            div.add(number%10);
            number /= 10;
        }

        Collections.reverse(div);
        return div;
    }
}
