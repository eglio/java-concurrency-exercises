import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 08/06/17.
 */
public class BufferSemaphore {
    private ArrayList<int> buffer;
    private Semaphore notPieno;
    private Semaphore notVuoto;

    public BufferSemaphore(){
        buffer=new ArrayList<int>();
        notPieno=new Semaphore(1);
        notVuoto=new Semaphore(1);
    }
    public void put (int elem) throws InterruptedException{
        notPieno.acquire();
        buffer.add(elem);

    }

    public int get(){
        return buffer.remove(0)
    }
}
