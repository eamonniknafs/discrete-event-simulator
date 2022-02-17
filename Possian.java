import java.lang.Math;

public class Possian {
    public static double getPossian(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        double k = 0.0;
        while (p > L) {
            k++;
            p *= Math.random();
        }
        return k - 1;
    }
}