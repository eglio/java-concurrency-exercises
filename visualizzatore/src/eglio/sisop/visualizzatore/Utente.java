package eglio.sisop.visualizzatore;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by egliocz on 12/06/17.
 */
public class Utente extends Thread{
    private CodaCondivisa coda;
    private Random rnd;

    public void run(){
        Integer iterazione =0;
        System.out.println("utente attivo");
        while(true){
            iterazione++;
            LinkedList<String> elementi = new LinkedList<>();
            int numElementi=1+rnd.nextInt(4); //da 1 a 5
            for (int i=0; i< numElementi; i++){
                String elem=iterazione.toString() +"-"+ i;
                elementi.add(elem);
            }
            try {
                coda.addCollection(elementi);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public Utente(CodaCondivisa c){
        coda=c;
        rnd= new Random();
    }

}
