package eglio.sisop.camerieri;

import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 12/06/17.
 */
public class Lavapiatti extends Thread{
    private SupportoPiattiSemaphore scolaPiatti;
    private SupportoPiattiLC contenitore;
    private int tempoLavaggio = 2;
    private int piattiLavati=1;

    public Lavapiatti(SupportoPiattiLC contenitore, SupportoPiattiSemaphore scolaPiatti){
        this.scolaPiatti=scolaPiatti;
        this.contenitore=contenitore;
    }

    public void run(){
        while(true){
            contenitore.get(piattiLavati);
            try{
                TimeUnit.SECONDS.sleep(tempoLavaggio);} catch (InterruptedException e) {
                e.printStackTrace();
            }
            scolaPiatti.put(piattiLavati);
            System.out.println("piatto lavato");
        }
    }

}
