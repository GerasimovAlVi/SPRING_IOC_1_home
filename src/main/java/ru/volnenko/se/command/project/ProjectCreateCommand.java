package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.ScannerService;

/**
 * @author Denis Volnenko
 */
@Component
public class ProjectCreateCommand extends AbstractCommand {

    private ProjectService projectService;
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    private ScannerService scannerService;
    @Autowired
    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    @EventListener(condition ="'project-create' eq #event.command")
    public void execute(CommandEvent event) {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = scannerService.nextLine();
        projectService.getProjectRepository().createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
