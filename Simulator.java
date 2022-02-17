import java.util.ArrayList;
import java.util.PriorityQueue;

public class Simulator {
    static void simulate(double time, double lambda, double T_s) {
        PriorityQueue<Event> timeline = new PriorityQueue<Event>();
        Double curr_time = 0.0;
        int id = 0;
        ArrayList<Double> tresp = new ArrayList<Double>();
        ArrayList<Integer> qlen = new ArrayList<Integer>();
        Double running_time = 0.0;
        int running = -1;
        Event temp = null;
        while (curr_time < time) {
            Event e = timeline.poll();
            if (temp != null) {
                timeline.add(temp);
                temp = null;
            }
            qlen.add(timeline.size());
            if (e == null) {
                timeline.add(new Event(id, curr_time, T_s));
                id++;
            } else {
                if (e.getStatus() == 0 && running == -1) {
                    running = e.getId();
                    timeline.add(e.Start(curr_time));
                    Double exp = Exp.getExp(lambda);
                    if (curr_time + exp < time) {
                        timeline.add(new Event(id, curr_time + exp, T_s));
                        curr_time += exp;
                        id++;
                    }
                    else{
                        break;
                    }
                } else if (e.getStatus() == 1 && running == e.getId()) {
                    if (curr_time + T_s < time) {
                        timeline.add(e.Done(curr_time + T_s));
                        curr_time += T_s;
                        running = -1;
                    }
                    else{
                        break;
                    }
                } else if (e.getStatus() == 2) {
                    Double exp = Exp.getExp(lambda);
                    if (curr_time + exp < time) {
                        running_time += e.getDone() - e.getStart();
                        tresp.add(e.getDone() - e.getArr());
                        timeline.add(new Event(id, curr_time + exp, T_s));
                        curr_time += exp;
                        id++;
                    }
                    else{
                        break;
                    }
                } else {
                    temp = e;
                }
            }
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