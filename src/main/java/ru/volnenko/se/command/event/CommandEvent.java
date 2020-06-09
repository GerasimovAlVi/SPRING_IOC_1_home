package ru.volnenko.se.command.event;

import org.springframework.context.ApplicationEvent;

public class CommandEvent extends ApplicationEvent {

    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CommandEvent(Object source) {
        super(source);
    }
}
