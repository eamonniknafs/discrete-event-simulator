import java.lang.Math;

public class Exp {
    public static double getExp(double lambda) {
        return Math.log(1 - Math.random()) / (-lambda);
    }
}