package eduflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot {
    public static void main(String[] args) {
        System.out.println("started");
        SpringApplication.run(ApplicationBoot.class, args);
    }
}
