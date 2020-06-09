package ru.volnenko.se.command.project;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    @EventListener(condition ="'project-remove' eq #event.command")
    public void execute(CommandEvent event) {

    }

}
