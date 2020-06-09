package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskClearCommand extends AbstractCommand {

    private TaskService taskService;
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    @Async
    @EventListener(condition ="'task-clear' eq #event.command")
    public void execute(CommandEvent event) {
        taskService.getTaskRepository().clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}
