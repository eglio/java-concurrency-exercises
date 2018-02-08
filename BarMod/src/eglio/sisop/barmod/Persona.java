package eglio.sisop.barmod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 09/06/17.
 */
public class Persona extends Thread{
    private Bar bar;
    private int scelta;

    public Persona(Bar bar){
        this.bar=bar;
    }
    public void run() {
        Random r = new Random();
        scelta = bar.scegli();
            if (scelta == 1) { //1=paga
                try {
                    bar.inizia(1);
                    int tempo = 2 + r.nextInt(2);
                    TimeUnit.SECONDS.sleep(tempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bar.finisci(1);
            } else {
                try {
                    bar.inizia(0);
                    int tempo = 5 + r.nextInt(5);
                    TimeUnit.SECONDS.sleep(tempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bar.finisci(0);
            }


        }
    }