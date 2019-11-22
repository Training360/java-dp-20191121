package builder;

import java.time.LocalDateTime;

public class Point {

    private double lat;

    private double lon;

    private double elevation;

    private LocalDateTime time;

    public Point(double lat, double lon, double elevation, LocalDateTime time) {
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.time = time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getElevation() {
        return elevation;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
