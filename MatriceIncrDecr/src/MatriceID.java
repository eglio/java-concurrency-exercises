/**
 * Created by egliocz on 08/06/17.
 */
public class MatriceID {
    private int[][] matrice;

    public MatriceID(int[]][] matr){this.matrice=matr;}

    public void incrementa(int riga) throws InterruptedException {
        for (int j=0, j<matrice[riga].length, j++) matrice[riga][j]++;
    }
    public void decrementa(int riga) throws InterruptedException {
        for (int j = 0;<matrice[riga].length, j++) matrice[riga][j]--;
    }


}
