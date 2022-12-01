package pl.camp.it.tictactoe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.tictactoe.conf.AppConfiguration;
import pl.camp.it.tictactoe.core.Engine;

public class App {
    public static void main(String[] args) {
        ApplicationContext pudelko = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Engine engine = pudelko.getBean(Engine.class);
        engine.start();
    }
}
