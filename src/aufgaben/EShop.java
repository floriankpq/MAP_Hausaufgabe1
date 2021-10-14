package aufgaben;

public class EShop {

    private int[] tastatur;
    private int[] usb;
    private int geld;

    public EShop(int[] tastatur, int[] usb, int geld) {
        this.tastatur = tastatur;
        this.usb = usb;
        this.geld = geld;
    }

    //returneaza cea mai ieftina tastatura
    //pre: -
    //post: min e cea mai ieftina tastatura
    public int minKeyboard(){

        int min = this.tastatur[0];
        for(int tastatur : this.tastatur){
            if(tastatur < min){
                min = tastatur;
            }
        }
        return min;
    }

    //returneaza cel mai scump obiect
    //pre: -
    //post: max e cel mai scump obiect
    public int mostExpensive(){

        int max = this.tastatur[0];

        for(int tastatur : this.tastatur){
            if(tastatur > max)
                max = tastatur;
        }

        for(int usb : this.usb){
            if(usb > max)
                max = usb;
        }

        return max;
    }

    //returneaza cel mai scump usb care se incadreaza in buget
    //pre: -
    //post: max=-1 cand nu exista & max<=buget in caz contrar
    public int clientBestUsbBuy(){

        int max = -1;

        for(int usb : this.usb){
            if(usb <= this.geld && usb > max)
                max = usb;
        }

        return max;
    }

    //returneaza pretul obiectelor care insumate se apropie cat mai tare de buget
    //pre: -
    //post: products=-1 daca nu exista sau pretul in caz contrar
    public int[] clientBestOverallBuy(){

        int[] products = {0, 0};
        int[] notPossible = {-1};
        int minDifference = this.geld;

        for(int i=0; i<this.usb.length; i++){

            if(this.usb[i] >= this.geld) {
                i++;
                if(i == this.usb.length)
                    break;
            }

            for(int j=0; j<this.tastatur.length; j++){

                if(this.tastatur[j] >= this.geld) {
                    j++;
                    if(j == this.tastatur.length)
                        break;
                }

                if((this.usb[i] + this.tastatur[j]) <= this.geld) {
                    if (this.geld - (this.usb[i] + this.tastatur[j]) < minDifference) {

                        minDifference = this.geld - (this.usb[i] + this.tastatur[j]);
                        products[0] = this.usb[i];
                        products[1] = this.tastatur[j];
                    }
                }
            }
        }

        if(minDifference == this.geld)
            return notPossible;
        return products;
    }
}
