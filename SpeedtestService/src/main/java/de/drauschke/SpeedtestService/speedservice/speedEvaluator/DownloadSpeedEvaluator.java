package de.drauschke.SpeedtestService.speedservice.speedEvaluator;

import de.drauschke.SpeedtestService.configuration.DownloadConfiguration;
import fr.bmartel.speedtest.SpeedTestSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Evaluates the download rate of the used network. */
@Service
public class DownloadSpeedEvaluator extends SpeedEvaluator {
  private static final Logger LOGGER = LoggerFactory.getLogger(UploadSpeedEvaluator.class);
  private final String url;

  public DownloadSpeedEvaluator(DownloadConfiguration downloadConfiguration) {
    super(downloadConfiguration.getSocketTimeout());
    this.url = downloadConfiguration.getUrl();
  }

  @Override
  void evaluateSpeed(SpeedTestSocket speedTestSocket) {
    LOGGER.info("Starting download speed test.");
    speedTestSocket.startDownload(url);
  }
}
