package io.github.michaldo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HelloApplication extends Application implements ApplicationContextAware {

    private static ConfigurableApplicationContext springContext;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop()  {
        springContext.close();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
        launch();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)  {
        HelloApplication.springContext = (ConfigurableApplicationContext) applicationContext;
    }
}