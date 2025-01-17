import segmentswork.SegmentsConstants;

public class CorridorSegment extends Segment {
    public CorridorSegment(MapGame mapGame, int parent_id) {
        super(SegmentsConstants.CORRIDOR_DESCRIPTION, mapGame, parent_id);
    }
}
