package ru.volnenko.se;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.volnenko.se.config.ApplicationConfig;
import ru.volnenko.se.controller.Bootstrap;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.start();
    }
}
