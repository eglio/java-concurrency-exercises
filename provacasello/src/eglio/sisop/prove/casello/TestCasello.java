package eglio.sisop.prove.casello;

/**
 * Created by egliocz on 08/06/17.
 */
public class TestCasello {
    private static int NUM_VEICOLI=10;
    public static void main(String[] args) throws InterruptedException
    {
        Casello c = new Casello(7, (float) 0.1);
        Veicolo[] veicoli= new Veicolo[NUM_VEICOLI];
        for(int i=0; i<NUM_VEICOLI; i++){
            veicoli[i]=new Veicolo(c);
            veicoli[i].start();
            System.out.println("veicolo " +i+ " partito");
        }
        for(int i=0; i<NUM_VEICOLI; i++){
            veicoli[i].join();
            System.out.println("attendo veicolo " +i);
        }
        System.out.println("incasso del giorno: € "+ c.getIncasso() );
    }
}
