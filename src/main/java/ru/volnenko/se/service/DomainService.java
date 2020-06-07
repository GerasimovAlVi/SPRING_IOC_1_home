package ru.volnenko.se.service;

import ru.volnenko.se.api.service.IDomainService;
import ru.volnenko.se.entity.Domain;

/**
 * @author Denis Volnenko
 */
public final class DomainService implements IDomainService {

    private ProjectService projectService;
    private TaskService taskService;

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        projectService.load(domain.getProjects());
        taskService.load(domain.getTasks());
    }

    @Override
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(projectService.getListProject());
        domain.setTasks(taskService.getListTask());
    }

}
