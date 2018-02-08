import java.util.Random;

public class Correntista extends Thread {
    private ContoCorrente conto;

    public Correntista(ContoCorrente cc) {
        this.conto = cc;
    }

    public void run() {
        int numOperazioni;
        int numCicli = 50;
        for (int i = 0; i < numCicli; i++) {
            try {
                conto.deposita(20);
                conto.preleva(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}