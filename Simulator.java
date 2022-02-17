public class Simulator {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double lambda = Double.parseDouble(args[1]);
        double T_s = Double.parseDouble(args[2]);
        Controller c = new Controller();
        c.simulate(T, lambda, T_s);
    }
}