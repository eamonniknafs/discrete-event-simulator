public class Request implements Comparable<Request> {
    private int id;
    // 0 = ARR, 1 = START, 2 = DONE
    private int status;
    private Double arr;
    private Double start;
    private Double done;

    /* Verbose constructor */
    public Request(int id, Double ts) {
        super();
        this.id = id;
        this.arr = ts;
        this.status = 0;
    }

    public Request Start(Double ts) {
        this.status = 1;
        this.start = ts;
        return this;
    }

    public Request Finish(Double ts) {
        this.status = 2;
        this.done = ts;
        return this;
    }

    /* timestamp getter */
    public Double getTimestamp() {
        switch (this.status) {
            case 0:
                return this.arr;
            case 1:
                return this.start;
            case 2:
                return this.done;
            default:
                return null;
        }
    }  
    
    @Override
    public int compareTo(Request rq) {
        return this.getTimestamp().compareTo(rq.getTimestamp());
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
        return "R" + id + " " + getStatusString()+": " + getTimestamp();
    }
}