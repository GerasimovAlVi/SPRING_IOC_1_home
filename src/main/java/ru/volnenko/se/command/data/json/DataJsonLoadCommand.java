package ru.volnenko.se.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.event.CommandEvent;
import ru.volnenko.se.constant.DataConstant;
import ru.volnenko.se.entity.Domain;
import ru.volnenko.se.service.DomainService;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
public class DataJsonLoadCommand extends AbstractCommand {

    private DomainService domainService;
    @Autowired
    public void setDomainService(DomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "Load Domain from JSON.";
    }

    @Override
    @Async
    @EventListener(condition ="'data-json-load' eq #event.command")
    public void execute(CommandEvent event) throws Exception {
        System.out.println("[LOAD JSON DATA]");
        final File file = new File(DataConstant.FILE_JSON);
        if (!exists(file)) return;
        final byte[] bytes = Files.readAllBytes(file.toPath());
        final String json = new String(bytes, "UTF-8");
        final ObjectMapper objectMapper = new ObjectMapper();
        final Domain domain = objectMapper.readValue(json, Domain.class);
        domainService.load(domain);
        System.out.println("[OK]");
    }

    private boolean exists(final File file) {
        if (file == null) return false;
        final boolean check = file.exists();
        if (!check) System.out.println("FILE NOT FOUND");
        return check;
    }

}
