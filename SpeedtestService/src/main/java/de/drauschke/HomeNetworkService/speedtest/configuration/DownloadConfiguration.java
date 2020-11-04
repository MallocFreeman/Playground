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
@ConfigurationProperties(prefix = "homenetwork.speedtest.download")
public class DownloadConfiguration {
  @NotEmpty private String url;

  @Min(0)
  private int socketTimeout;
}
