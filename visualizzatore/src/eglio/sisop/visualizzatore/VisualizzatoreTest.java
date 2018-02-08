package eglio.sisop.visualizzatore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by egliocz on 12/06/17.
 */
public class VisualizzatoreTest {
    public static void main(String args[]){
        CodaCondivisa coda = new CodaCondivisa();
        int NUM_UTENTI=100;
        Utente[] utenti= new Utente[NUM_UTENTI];

        Visualizzatore visualizer=new Visualizzatore(coda);
        visualizer.start();

        for (int i=0; i<NUM_UTENTI; i++){
            utenti[i]=new Utente(coda);
            utenti[i].start();
        }
    }
}
