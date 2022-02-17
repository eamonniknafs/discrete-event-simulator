import java.util.ArrayList;
import java.util.PriorityQueue;

public class Simulator {
    


    static void simulate(double time, double lambda, double T_s) {
        PriorityQueue<Event> timeline = new PriorityQueue<Event>();
        ArrayList<Double> tresp = new ArrayList<Double>();
        ArrayList<Integer> qlen = new ArrayList<Integer>();
        Double running_time = 0.0;

        Double curr_time = 0.0;
        while (curr_time < time){

        }
        System.out.println("UTIL: "+running_time/time);
        System.out.println("QLEN: "+qlen.stream().mapToDouble(d -> d).average().orElse(0.0));
        System.out.println("TRESP: "+tresp.stream().mapToDouble(d -> d).average().orElse(0.0));
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double lambda = Double.parseDouble(args[1]);
        double T_s = Double.parseDouble(args[2]);
        simulate(T, lambda, T_s);
    }
}