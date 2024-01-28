package net.tryhard.crudgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "net.tryhard.crudgradle.mapper")

public class CrudGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudGradleApplication.class, args);
    }

}
