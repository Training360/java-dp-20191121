package command;

public interface Command {

    boolean isCreate();

    String getLocationId();

    Location createLocation();

    void modifyLocation(Location location);
}
