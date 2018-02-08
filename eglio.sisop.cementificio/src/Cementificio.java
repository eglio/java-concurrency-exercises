/**
 * Created by egliocz on 14/06/17.
 */
public abstract class Cementificio {
    protected int n; //MAX_CLIENTI
    protected int p; //NUM_SACCHI

    public abstract void entra();
    public abstract void esci();
    public abstract void preleva(); //1 sacco alla volta
    public abstract void iniziaRifornimento();
    public abstract void terminaRifornimento();

    public Cementificio(int n, int p){
        this.n=n;
        this.p=p;
    }
}
