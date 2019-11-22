package builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrackBuilder {

    private String name;

    private TrackType trackType;

    private List<Point> points = new ArrayList<>();

    public TrackBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TrackBuilder withTrackType(TrackType trackType) {
        this.trackType = trackType;
        return this;
    }

    public TrackBuilder withPoint(double lat, double lon, double elevation, LocalDateTime time) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Lat must be between -90 and +90");
        }
        if (lon < -180 || lon > +180) {
            throw new IllegalArgumentException("Lat must be between -180 and +180");
        }
        Point point = new Point(lat, lon, elevation, time);
        points.add(point);
        return this;
    }

    public Track build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Name is required");
        }
        return new Track(name, trackType, points);
    }
}
