package eglio.sisop.barmod;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 09/06/17.
 */
public class Bar {
    private int[] lunghezzaCoda = new int[NUM_CODE];
    private static int NUM_CODE = 2;
    private Semaphore cassa = new Semaphore(1, true);
    private Semaphore bancone = new Semaphore(4, true);
    private int serviti = 0, pagati =0;

    // 1 paga,0 bevi
    public int scegli() {
        if (lunghezzaCoda[1] > lunghezzaCoda[0]) {
            return 0;
        } //bevi
        else {
            return 1;
        } //paga

    }

    void inizia(int scelta) throws InterruptedException {
        lunghezzaCoda[scelta]++;
        if (scelta == 1) { //paga
            cassa.acquire();
            pagati++;
            System.out.println(pagati +" pagati");

        } else { //bevi
            bancone.acquire();
            serviti++;
            System.out.println(serviti+" serviti");

        }
        lunghezzaCoda[scelta]--;
    }

    void finisci(int scelta) { //finisci paga o bevi
        if (scelta == 1) { //paga
            cassa.release();
        } else { //bevi
            bancone.release();

        }
    };
}
