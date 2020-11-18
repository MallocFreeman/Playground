package de.drauschke.HomeNetworkService.speedtest.speedEvaluator;

import de.drauschke.HomeNetworkService.speedtest.configuration.UploadConfiguration;
import fr.bmartel.speedtest.SpeedTestSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Evaluates the upload rate of the used network. */
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
