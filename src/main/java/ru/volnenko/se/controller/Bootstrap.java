package ru.volnenko.se.controller;

import ru.volnenko.se.command.*;
import ru.volnenko.se.service.ScannerService;

import java.util.*;

/**
 * @author Denis Volnenko
 */
public final class Bootstrap {

    private Map<String, AbstractCommand> commands = new LinkedHashMap<>();
    private ScannerService scannerService;

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void setCommands(Map<String, AbstractCommand> commands) {
        this.commands = commands;
    }

    public void init() throws Exception {
        start();
    }

    private void start() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = scannerService.nextLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }
}
