package ru.volnenko.se.command;

import ru.volnenko.se.service.DomainService;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.ScannerService;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
public abstract class AbstractCommand {

    private TaskService taskService;
    private ProjectService projectService;
    private DomainService domainService;
    private ScannerService scannerService;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public DomainService getDomainService() {
        return domainService;
    }

    public void setDomainService(DomainService domainService) {
        this.domainService = domainService;
    }

    public ScannerService getScannerService() {
        return scannerService;
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();
}
