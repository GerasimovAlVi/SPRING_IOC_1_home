package ru.volnenko.se.command.data.bin;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
public class DataBinaryClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "Remove binary data.";
    }

    @Override
    @Async
    @EventListener(condition ="'data-bin-clear' eq #event.command")
    public void execute(CommandEvent event) throws Exception {
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
    }

}
