package eglio.sisop.visualizzatore;

/**
 * Created by egliocz on 12/06/17.
 */
public class Visualizzatore extends Thread {
    private CodaCondivisa coda;
    public void run(){
        System.out.println("visualizzatore attivo");
        while(true){
            try {
                System.out.println("visualizzo...");
                System.out.println(coda.getFirst());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Visualizzatore(CodaCondivisa coda){
        this.coda=coda;
    }
}
