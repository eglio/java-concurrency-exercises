package eglio.sisop.comp;

import java.util.LinkedList;

/**
 * Created by egliocz on 12/06/17.
 */
public class Computer {

    public static void main(String[] args) {
        int NUM_PROCESSORI = 2;
        ProcessoreLC[] processori = new ProcessoreLC[NUM_PROCESSORI];
        int NUM_UTENTI = 10;
        LinkedList<Thread> utenti =new LinkedList<>();

        for (int i=0; i<NUM_PROCESSORI; i++){
            processori[i]=new ProcessoreLC();
        }

        for (int i=0; i<NUM_UTENTI; i++){
            Thread utente = new Utente(processori, utenti);
            utente.start();
        }
    }
}

