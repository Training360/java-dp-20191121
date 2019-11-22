package command;

import java.util.Optional;

public class MoveToCommand implements Command {

    private String id;

    private int x;

    private int y;

    public MoveToCommand(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isCreate() {
        return false;
    }

    @Override
    public String getLocationId() {
        return id;
    }

    @Override
    public Location createLocation() {
        throw new IllegalStateException("Not implemented");
    }

    @Override
    public void modifyLocation(Location location) {
        location.setX(x);
        location.setY(y);
    }
}
