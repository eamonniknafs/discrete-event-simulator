public class Controller {

    void createAndAddRequest(State s, double t) {
        Request r = new Request(s.tot_rq_num, t);
        s.tot_rq_num++;
        s.requestQueue.add(r);
    }

    void updateStateVariables(State s) {
        s.tot_qu_len += s.requestQueue.size();
        s.num_monitors ++;
    }

    void updateStateVariables(Request rq, State s) {
        s.num_completed_rq++;
        s.tot_rq_time += rq.getDone() - rq.getArr();
        s.busy_time += rq.getDone() - rq.getStart();
    }

    void executeEvent(Event e, State s) {
        if (e.type.equals("BIRTH")) {
            createAndAddRequest(s, e.time);
            s.timeline.add(new Event("BIRTH", e.time + Exp.getExp(s.lambda)));
            if (s.requestQueue.size() == 1) {
                s.requestQueue.peek().start(e.time);
                s.timeline.add(new Event("DEATH", e.time + Exp.getExp(s.T_s)));
            }
        } else if (e.type.equals("MONITOR")) {
            updateStateVariables(s);
            s.timeline.add(new Event("MONITOR", e.time + 1));
        } else if (e.type.equals("DEATH")) {
            Request rq = s.requestQueue.poll();
            rq.finish(e.time);
            updateStateVariables(rq, s);
            // if (s.requestQueue.size() > 0) {
            //     s.requestQueue.peek().start(e.time);
            //     s.timeline.add(new Event("DEATH", e.time + Exp.getExp(s.T_s)));
            // }
        }
    }

    void simulate(double duration, double lambda, double T_s) {
        State state = new State();
        state.initiateState(lambda, T_s);
        state.initiateTimeline();

        while (state.timeline.peek().time < duration) {
            Event e = state.timeline.poll();
            executeEvent(e, state);
        }

        Double util = state.lambda*state.T_s;
        Double qlen = (util*util)/(1-util);
        Double tresp = (util/(1-util))/(state.lambda);

        System.out.println("UTIL: "+util);
        System.out.println("QLEN: "+qlen);
        System.out.println("TRESP: "+tresp);
    }
}
