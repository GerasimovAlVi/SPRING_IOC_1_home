package ru.volnenko.se.command.system;

import ru.volnenko.se.command.AbstractCommand;

import java.util.List;

/**
 * @author Denis Volnenko
 */
public final class HelpCommand extends AbstractCommand {

    private List<AbstractCommand> commands;

    public void setCommands(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (AbstractCommand command: commands) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

}
