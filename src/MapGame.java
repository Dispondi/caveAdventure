import java.util.ArrayList;
import java.util.List;

public class MapGame {
    private final List<Segment> segments = new ArrayList<>();

    public void addSegment(Segment segment) {
        segments.add(segment);
    }

    public Segment getSegment(int i) {
        return segments.get(i);
    }

    public Integer findNumberOfSegment(Segment segment) {
        for (int i = 0; i < segments.size(); i++) {
            if (segment == segments.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
