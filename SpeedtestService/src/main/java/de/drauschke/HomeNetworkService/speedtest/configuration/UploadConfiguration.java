package de.drauschke.HomeNetworkService.speedtest.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "homenetwork.speedtest.upload")
public class UploadConfiguration {
  @NotEmpty private String url;

  @Min(1000)
  private int fileSize;

  @Min(0)
  private int socketTimeout;
}
