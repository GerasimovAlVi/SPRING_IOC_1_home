package ru.volnenko.se.command;

import ru.volnenko.se.command.event.CommandEvent;

/**
 * @author Denis Volnenko
 */
public abstract class AbstractCommand {

    public abstract void execute(CommandEvent event) throws Exception;

    public abstract String command();

    public abstract String description();
}
