package command;


import java.util.Optional;

public class CreateLocationCommand implements Command {

    private String id;

    private String name;

    private int x;

    private int y;

    public CreateLocationCommand(String id, String name, int x, int y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isCreate() {
        return true;
    }

    @Override
    public Location createLocation() {
        return new Location(id, name, x, y);
    }

    @Override
    public String getLocationId() {
        return id;
    }

    @Override
    public void modifyLocation(Location location) {
        throw new IllegalStateException("Not implemented");
    }
}
