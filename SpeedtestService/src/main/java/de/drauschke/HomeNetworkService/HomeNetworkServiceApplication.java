package de.drauschke.HomeNetworkService;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@AllArgsConstructor
@SpringBootApplication
@ComponentScan(
    basePackages = {
      "de.drauschke.HomeNetworkService",
      "de.drauschke.HomeNetworkService.api",
      "de.drauschke.HomeNetworkService.configuration"
    })
public class HomeNetworkServiceApplication {
  public static void main(String[] args) {
    new SpringApplication(HomeNetworkServiceApplication.class).run(args);
  }
}
