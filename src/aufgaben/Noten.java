package aufgaben;
import java.util.ArrayList;

public class Noten {

    private ArrayList<Integer> noten = new ArrayList<Integer>();

    public Noten(ArrayList<Integer> noten) {
        this.noten = noten;
    }

    //calculeaza cel mai apropiat numar divizibil cu 5 mai mare decat x
    //pre: type(x)=int
    //post: cx e cel mai mic numar divizibil de 5 mai mare decat x
    public int aufrunden(int x){

        int cx = x;

        while(cx%5!=0)
            cx++;

        return cx;
    }

    //formeaza array cu notele care nu sunt de trecere
    //pre: -
    //post: bad contine toate notele cerute de cerinta
    public ArrayList<Integer> badGrades(){

        ArrayList<Integer> bad = new ArrayList<Integer>();

        for(int i : this.noten)
            if(i < 38)
                bad.add(i);

        return bad;
    }

    //calculeaza media
    //pre: -
    //post: (float)sum/ rounded.size()=media
    public float average(){

        int sum = 0;
        ArrayList<Integer> rounded = this.roundedGrades();

        for(int note : rounded)
            sum += note;

        return (float)sum/ rounded.size();
    }

    //rotunjeste notele respectand cerinta
    //pre:-
    //post: notele sunt rotunjite
    public ArrayList<Integer> roundedGrades(){

        ArrayList<Integer> rounded = new ArrayList<Integer>();

        for(int i : this.noten){
            if((aufrunden(i)-i)<3 && i >= 38)
                rounded.add(aufrunden(i));
            else
                rounded.add(i);
        }
        return rounded;
    }

    //calculeaza cea mai mare nota rotunjita
    //pre: -
    //post: maxRounded e cea mai mare nota rotunjita
    public int maxRoundedGrade(){

        ArrayList<Integer> rounded = this.roundedGrades();
        int maxRounded = rounded.get(0);

        for(int grade : rounded)
            if(grade > maxRounded)
                maxRounded = grade;

        return maxRounded;
    }

}
