package de.drauschke.SpeedtestService.speedservice.speedEvaluator;

import de.drauschke.SpeedtestService.configuration.UploadConfiguration;
import fr.bmartel.speedtest.SpeedTestSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UploadSpeedEvaluator extends SpeedEvaluator {
  private static final Logger LOGGER = LoggerFactory.getLogger(UploadSpeedEvaluator.class);
  private final String url;
  private final int uploadFileSize;

  public UploadSpeedEvaluator(UploadConfiguration uploadConfiguration) {
    super(uploadConfiguration.getSocketTimeout());
    url = uploadConfiguration.getUrl();
    uploadFileSize = uploadConfiguration.getFileSize();
  }

  @Override
  void evaluateSpeed(SpeedTestSocket speedTestSocket) {
    LOGGER.info("Starting upload speed test.");
    speedTestSocket.startUpload(url, uploadFileSize);
  }
}
