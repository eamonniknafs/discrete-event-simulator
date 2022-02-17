import java.util.LinkedList;
import java.util.Queue;

public class Timeline {
    Queue<Event> timeline;
    void initiateTimeline(){
        timeline = new LinkedList<Event>();
        timeline.add(new Event("BIRTH"));
        timeline.add(new Event("MONITOR"));
    }
}
