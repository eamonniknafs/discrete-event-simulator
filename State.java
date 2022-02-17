import java.util.PriorityQueue;

public class State {
    PriorityQueue<Request> requestQueue;
    PriorityQueue<Event> timeline;

    int tot_qu_len;
    Double tot_rq_time;
    Double busy_time;
    int num_monitors;
    int num_completed_rq;

    int tot_rq_num;

    Double lambda;
    Double T_s;

    void initiateTimeline() {
        timeline = new PriorityQueue<Event>();
        timeline.add(new Event("BIRTH", 0.0));
        timeline.add(new Event("MONITOR", 0.0));
    }

    void initiateState(Double lambda, Double T_s) {
        requestQueue = new PriorityQueue<Request>();
        tot_qu_len = 0;
        tot_rq_time = 0.0;
        busy_time = 0.0;
        num_monitors = 0;
        num_completed_rq = 0;
        tot_rq_num = 0;
        this.lambda = lambda;
        this.T_s = T_s;
    }
}
