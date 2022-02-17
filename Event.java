public class Event implements Comparable<Event> {
    String type;
    Double time;

    public Event(String type, Double time) {
        this.type = type;
        this.time = time;
    }

    @Override
    public int compareTo(Event e) {
        return this.time.compareTo(e.time);
    }
}
