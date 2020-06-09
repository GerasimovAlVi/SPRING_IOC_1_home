package ru.volnenko.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.service.ScannerService;

/**
 * @author Denis Volnenko
 */
@Component
public final class Bootstrap {

    @Autowired
    private ApplicationEventPublisher publisher;

    private ScannerService scannerService;
    @Autowired
    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void start() {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        final CommandEvent commandEvent = new CommandEvent(this);
        while (!"exit".equals(command)) {
            command = scannerService.nextLine();
            if (command != null && !command.isEmpty()){
                commandEvent.setCommand(command);
                publisher.publishEvent(commandEvent);
            }
        }
    }
}
