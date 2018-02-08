package eglio.sisop.comp;

/**
 * Created by egliocz on 12/06/17.
 */
public interface Processore {
    public void assegna (int numCore);

    void rilascia(int numCore);
}
