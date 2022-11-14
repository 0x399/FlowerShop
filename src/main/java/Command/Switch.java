package Command;

import java.text.ParseException;
import java.util.HashMap;

public class Switch implements Command {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) throws ParseException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }
        command.execute();
    }

    @Override
    public void execute() throws ParseException {

    }
}
