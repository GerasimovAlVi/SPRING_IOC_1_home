package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component
public class ProjectClearCommand extends AbstractCommand {

    private ProjectService projectService;
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    @Async
    @EventListener(condition ="'project-clear' eq #event.command")
    public void execute(CommandEvent event) {
        projectService.getProjectRepository().clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}
