package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.ScannerService;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskCreateCommand extends AbstractCommand {

    private TaskService taskService;
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    private ScannerService scannerService;
    @Autowired
    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    @EventListener(condition ="'task-create' eq #event.command")
    public void execute(CommandEvent event) {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = scannerService.nextLine();
        taskService.getTaskRepository().createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
