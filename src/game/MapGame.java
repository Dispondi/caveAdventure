package game;

import segments.Segment;

import java.util.ArrayList;
import java.util.List;

public class MapGame {
    private final List<Segment> segments;
    public int segmentID;

    public MapGame() {
        segments = new ArrayList<>();
        segmentID = 0;
    }

    public void addSegment(Segment segment) {
        segments.add(segment);
        segmentID++;
    }

    public Segment getSegment(int i) {
        return segments.get(i);
    }

    public int getMapLength() {
        return segments.size();
    }

    public int findNumberOfSegment(Segment segment) {
        for (int i = 0; i < segments.size(); i++) {
            if (segment == segments.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
