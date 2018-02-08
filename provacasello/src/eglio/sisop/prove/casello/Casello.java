package eglio.sisop.prove.casello;

import java.util.Random;
/**
 * Created by egliocz on 08/06/17.
 */
public class Casello {
    private int N; //num porte
    private float T; //tariffa chilometrica
    private float incasso;
    private Porta[] porte;
    private Random r = new Random();

    public Casello(int numPorte, float tariffa) {
        this.N=numPorte;
        this.T=tariffa;
        this.incasso = 0;
        porte= new Porta[N];
        for (int i=0; i<N; i++){
            porte[i]=new Porta(T);
        }
    }

    public Porta scegliPorta(int scelta){
        return porte[scelta];
    }

    public int getN(){
        return N;
    }

    public float getIncasso(){
        for (Porta p : porte){
            incasso+=p.getIncassoPorta();
        }
        return incasso;
    }

    public float getT(){
        return T;
    }

}
