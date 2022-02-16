import java.lang.Math;

public class Exp{
    public static double getExp(double lambda){
        return Math.log(1-Math.random())/(-lambda);
    }

    public static void main(String[] args){
        double lambda = Double.parseDouble(args[0]);
        double N = Double.parseDouble(args[1]);
        for (int i = 0; i < N; i++){
            System.out.println(getExp(lambda));
        }
    }
}