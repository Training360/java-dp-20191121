package builder;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrackBuilderTest {

    @Test
    public void testBuildTrack() {
        Track track = new TrackBuilder()
                .withName("Test Track")
                .withTrackType(TrackType.HIKING)
                .withPoint(47.49801, 19.03991, 130, LocalDateTime.now())
                .withPoint(47.49802, 19.03992, 131, LocalDateTime.now())
                .build();

        assertThat(track.getName(), equalTo("Test Track"));
        assertThat(track.getTrackType(), equalTo(TrackType.HIKING));
        assertThat(track.getPoints().get(0).getLat(), equalTo(47.49801));
        assertThat(track.getPoints().get(1).getElevation(), equalTo(131.0));
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyName() {
        new TrackBuilder().build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatLower() {
        new TrackBuilder().withPoint(-91, 0,0, LocalDateTime.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatHigher() {
        new TrackBuilder().withPoint(91, 0,0, LocalDateTime.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLonLower() {
        new TrackBuilder().withPoint(0, -181,0, LocalDateTime.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLonHigher() {
        new TrackBuilder().withPoint(0, 181,0, LocalDateTime.now());
    }
}
