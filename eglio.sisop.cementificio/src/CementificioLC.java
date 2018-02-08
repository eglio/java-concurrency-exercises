import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 14/06/17.
 */
public class CementificioLC extends Cementificio{
    private Lock posti = new ReentrantLock();
    private Lock sacchi = new ReentrantLock();
    private Condition sacchiDisponibili= sacchi.newCondition();
    private Condition postiDisponibili= posti.newCondition();
    private LinkedList<Cliente> codaClienti= new LinkedList<>();

    public void entra(){};
    public void esci(){};
    public void preleva(){};
    public void iniziaRifornimento(){};
    public void terminaRifornimento(){};



}
