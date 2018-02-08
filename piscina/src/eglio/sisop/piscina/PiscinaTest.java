package eglio.sisop.piscina;

/**
 * Created by egliocz on 13/06/17.
 */
public class PiscinaTest {
    public static void main(String[] args){
        int n=10;
        int x=4;
        int persone=10;
        Piscina p1 = new PiscinaSemaphore(n,x);
        Piscina p2 = new PiscinaLC(n,x);
        Persona[] piscina1 = new Persona[persone];
        Persona[] piscina2 = new Persona[persone];

        for (int i=0; i<persone; i++){
            piscina1[i] = new Persona(p1);
            piscina2[i]=new Persona(p2);
            piscina1[i].start();
            piscina2[i].start();
        }

        for (int i=0; i<persone; i++){
            try{
                piscina1[i].join();
                piscina2[i].join();
            }catch (InterruptedException e){e.printStackTrace();}
        }

    }

}
