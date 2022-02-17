import java.util.PriorityQueue;

public class State {
    PriorityQueue<Request> timeline;
    int tot_qu_len;
    Double tot_rq_time;
    Double busy_time;
    int tot_rq_num;

    void initiateState() {
        timeline = new PriorityQueue<Request>();
        tot_qu_len = 0;
        tot_rq_time = 0.0;
        busy_time = 0.0;
        tot_rq_num = 0;
    }
}
