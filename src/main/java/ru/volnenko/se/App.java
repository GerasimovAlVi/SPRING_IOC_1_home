package ru.volnenko.se;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.volnenko.se.controller.Bootstrap;

public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.init();
    }

}
