package eglio.sisop.barmod;

import java.util.Random;

/**
 * Created by egliocz on 09/06/17.
 */
public class BarModTest {

    public static void main(String args[]) throws InterruptedException {
        Random nr = new Random();
        Bar bar = new Bar();
        int NUM_CLIENTI=nr.nextInt(20);
        Thread[] clienti = new Thread[NUM_CLIENTI];
        System.out.println(NUM_CLIENTI+" clienti");
        for (int i =0; i<NUM_CLIENTI; i++){
            clienti[i]=new Persona(bar);
            clienti[i].start();
        }
        for (int i =0; i<NUM_CLIENTI; i++){
            clienti[i].join();
        }
        System.out.println("serviti tutti");
    }
}
