/**
 * Created by egliocz on 04/06/17.
 */
class CCTest {
    private static int NUM_CORRENTISTI = 15;
    static int DEPOSITO_INIZIALE = 1000;

    public static void main(String args[]) throws InterruptedException {
        ContoCorrente conto = new ContoCorrente(DEPOSITO_INIZIALE);
        Correntista[] correntisti = new Correntista[NUM_CORRENTISTI];

        for (int i = 0; i < NUM_CORRENTISTI; i++) {
            correntisti[i] = new Correntista(conto);
            correntisti[i].start();
        }

        for (int i = 0; i < NUM_CORRENTISTI; i++) {
            correntisti[i].join();
        }

        System.out.printf("%d -> %d \n", DEPOSITO_INIZIALE, conto.getDeposito());

            if ((DEPOSITO_INIZIALE - conto.getDeposito()) == 0)
                System.out.println("CORRETTO");
            else System.out.println("errore");
        }
}
