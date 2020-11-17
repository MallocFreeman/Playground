package de.drauschke.HomeNetworkService.speedtest;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResultPersister;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.DownloadSpeedEvaluator;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.SpeedEvaluationException;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.UploadSpeedEvaluator;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/** Service class to start a new speedtest and persist its data. */
@Service
@AllArgsConstructor
public class SpeedtestExecutor {
  private final UploadSpeedEvaluator uploadSpeedEvaluator;
  private final DownloadSpeedEvaluator downloadSpeedEvaluator;
  private final SpeedtestResultPersister speedtestResultPersister;

  /**
   * Starts a new speedtest.
   *
   * @return The result of the speedtest with upload and download speed rate.
   * @throws SpeedEvaluationException in case of an error such as timeouts or undefined behaviour.
   */
  @Cacheable(value="speedtestResult")
  public SpeedtestResult execute() throws SpeedEvaluationException, InterruptedException {
    SpeedtestResult speedtestResult = new SpeedtestResult();
    speedtestResult.setUpload(transformResult(uploadSpeedEvaluator.evaluate()));
    speedtestResult.setDownload(transformResult(downloadSpeedEvaluator.evaluate()));
    speedtestResult.setTimestamp(createTimestamp());
    speedtestResultPersister.persist(speedtestResult);
    return speedtestResult;
  }

  private int transformResult(BigDecimal value) {
    return value.intValue();
  }

  private String createTimestamp() {
    return new Timestamp(new Date().getTime()).toString();
  }
}
