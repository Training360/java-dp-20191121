package command;

import java.util.*;

public class LocationService {

    private Map<String, List<Command>> commands = new HashMap<>();

    public void receiveCommand(Command command) {
        if (command.isCreate()) {
            commands.put(command.getLocationId(), new ArrayList<>(List.of(command)));
        }
        else {
            commands.get(command.getLocationId()).add(command);
        }
    }

    public void undo(String id) {
        List<Command> commandsToExecute = commands.get(id);
        commandsToExecute.remove(commandsToExecute.size() - 1);
    }

    public Location findById(String id) {
        List<Command> commandsToExecute = commands.get(id);
        Location location = commandsToExecute.get(0).createLocation();
        for (Command command: commandsToExecute) {
            if (!command.isCreate()) {
                command.modifyLocation(location);
            }
        }
        return location;
    }
}
