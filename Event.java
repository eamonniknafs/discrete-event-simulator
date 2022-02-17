public class Event implements Comparable<Event> {

    private Double ts;
    private int id;
    // 0 = ARR, 1 = START, 2 = DONE
    private int status;
    private Double arr;
    private Double start;
    private Double done;

    /* Verbose constructor */
    public Event(int id, Double ts, Double T_s) {
        super();
        this.id = id;
        this.ts = ts;
        this.arr = ts;
        System.out.println(this);
    }

    public Event Start(Double ts) {
        this.ts = ts;
        this.status = 1;
        this.start = ts;
        System.out.println(this);
        return this;
    }

    public Event Done(Double ts) {
        this.ts = ts;
        this.status = 2;
        this.done = ts;
        System.out.println(this);
        return this;
    }

    @Override
    public int compareTo(Event evt) {
        return this.getTimestamp().compareTo(evt.getTimestamp());
    }

    /* timestamp getter */
    public Double getTimestamp() {
        return this.ts;
    }

    /* ID getter */
    public int getId() {
        return this.id;
    }

    /* arr getter */
    public Double getArr() {
        return this.arr;
    }

    /* start getter */
    public Double getStart() {
        return this.start;
    }

    /* done getter */
    public Double getDone() {
        return this.done;
    }

    /* Status getter */
    public int getStatus() {
        return this.status;
    }

    /* status string getter */
    public String getStatusString() {
        if (this.status == 0) {
            return "ARR";
        } else if (this.status == 1) {
            return "START";
        } else if (this.status == 2) {
            return "DONE";
        } else {
            return "UNKNOWN";
        }
    }

    /* status setter */
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "R" + id + " " + getStatusString()+": " + ts;
    }
}