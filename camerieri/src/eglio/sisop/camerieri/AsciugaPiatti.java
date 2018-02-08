package eglio.sisop.camerieri;

import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 12/06/17.
 */
public class AsciugaPiatti extends Thread{
    private int tempoAsciugatura = 1;
    private int piattiAsciugati = 1;
    private SupportoPiattiSemaphore contenitore;

    public AsciugaPiatti(SupportoPiattiSemaphore cont){
        contenitore=cont;
    }

    public void run(){
        while(true){
        try{
            TimeUnit.SECONDS.sleep(tempoAsciugatura);
        }catch (InterruptedException e) {e.printStackTrace();}
            contenitore.get(piattiAsciugati);
            System.out.println("piatto asciugato");
    }}
}
