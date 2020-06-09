package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.ScannerService;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskRemoveCommand extends AbstractCommand {

    private ScannerService scannerService;
    @Autowired
    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    @EventListener(condition ="'task-remove' eq #event.command")
    public void execute(CommandEvent event) {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task order index:");
        final Integer orderIndex = scannerService.nextInteger();
        if (orderIndex == null) {
            System.out.println("Error! Incorrect order index...");
            System.out.println();
            return;
        }
        System.out.println("[OK]");
    }

}
