import java.util.PriorityQueue;

public class Simulator{
    static void simulate(double time, double lambda, double T_s){
        PriorityQueue<Event> timeline = new PriorityQueue<Event>();
        Double curr_time = 0.0;
        int id = 0;
        while (curr_time < time){
            Event e = timeline.poll();
            if (e == null){
                timeline.add(new Event(id, curr_time, T_s));
                curr_time += Exp.getExp(lambda);
                id++;
            } else {
                if (e.getStatus() == 0){
                    Double exp = Exp.getExp(lambda);
                    timeline.add(e.Start(curr_time+exp));
                    curr_time += exp;
                } else if (e.getStatus() == 1){
                    timeline.add(e.Done(curr_time+T_s));
                    curr_time += T_s;
                } else if (e.getStatus() == 2){
                    timeline.add(new Event(id, curr_time, T_s));
                    id++;
                } else {
                    System.out.println("Error: Unknown event status");
                }
            }
        }
    }
 
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double lambda = Double.parseDouble(args[1]);
        double T_s = Double.parseDouble(args[2]);
        simulate(T, lambda, T_s);
    }
}