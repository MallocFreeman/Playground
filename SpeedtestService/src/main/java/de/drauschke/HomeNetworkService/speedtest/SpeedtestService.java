package de.drauschke.HomeNetworkService.speedtest;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.DownloadSpeedEvaluator;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.UploadSpeedEvaluator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/** Service class to start a new speedtest and persist its data. */
@Service
@AllArgsConstructor
public class SpeedtestService {
  private final UploadSpeedEvaluator uploadSpeedEvaluator;
  private final DownloadSpeedEvaluator downloadSpeedEvaluator;

  /**
   * Starts a new speedtest.
   *
   * @return The result of the speedtest with upload and download speed rate.
   * @throws Exception in case of an error such as timeouts or undefined behaviour.
   */
  public SpeedtestResult startSpeedtest() throws Exception {
    SpeedtestResult speedtestResult = new SpeedtestResult();
    speedtestResult.setUpload(transformResult(uploadSpeedEvaluator.evaluate()));
    speedtestResult.setDownload(transformResult(downloadSpeedEvaluator.evaluate()));
    speedtestResult.setTimestamp(createTimestamp());
    return speedtestResult;
  }

  private int transformResult(BigDecimal value) {
    return value.intValue();
  }

  private String createTimestamp() {
    return new Timestamp(new Date().getTime()).toString();
  }
}
