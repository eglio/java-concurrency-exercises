package eglio.sisop.camerieri;

/**
 * Created by egliocz on 12/06/17.
 */
public class RistoranteTest {
    public static int dimensione =50;

    public static void main(String[] args){
        SupportoPiattiLC contenitore = new SupportoPiattiLC(dimensione);
        SupportoPiattiSemaphore scolapiatti = new SupportoPiattiSemaphore(dimensione);

        for (int i=0; i<10; i++){
            Cameriere c = new Cameriere(contenitore);
            c.start();
        }

        for (int i=0; i<6; i++){
            Lavapiatti lavapiatti = new Lavapiatti(contenitore, scolapiatti);
            lavapiatti.start();
        }

        for (int i=0; i<10; i++){
            AsciugaPiatti a = new AsciugaPiatti(scolapiatti);
            a.start();
        }



    }
}
