import java.util.LinkedList;
import java.util.Queue;

public class Timeline {
    Queue<Event> timeline;
    void initiateTimeline(){
        timeline = new LinkedList<Event>();
        timeline.add(new Event("BIRTH", 0.0));
        timeline.add(new Event("MONITOR", 0.0));
    }
}
