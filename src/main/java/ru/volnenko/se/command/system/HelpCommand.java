package ru.volnenko.se.command.system;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;

import java.util.List;

/**
 * @author Denis Volnenko
 */
@Component
public class HelpCommand extends AbstractCommand {

    private List<AbstractCommand> commands;

    public HelpCommand(List<AbstractCommand> commands) {
        this.commands = commands;
        this.commands.add(this);
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
    @Async
    @EventListener(condition ="'help' eq #event.command")
    public void execute(CommandEvent event) {
        for (AbstractCommand command: commands) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }
}
