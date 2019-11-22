package command;

import java.util.Optional;

public class ChangeNameCommand implements Command {

    private String id;

    private String name;

    public ChangeNameCommand(String id, String name) {
        this.id = id;
        this.name = name;
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
        throw new IllegalArgumentException("Not implemented");
    }

    @Override
    public void modifyLocation(Location location) {
        location.setName(name);
    }
}
