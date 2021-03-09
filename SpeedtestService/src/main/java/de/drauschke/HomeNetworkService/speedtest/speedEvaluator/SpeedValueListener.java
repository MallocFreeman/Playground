package de.drauschke.HomeNetworkService.speedtest.speedEvaluator;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CountDownLatch;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the callback for the {@link ISpeedTestListener} used whenever the {@link
 * fr.bmartel.speedtest.SpeedTestSocket} gets used to perform a speedtest.
 */
@Data
public class SpeedValueListener implements ISpeedTestListener {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpeedValueListener.class);
  private final CountDownLatch countDownLatch;
  private SpeedTestError speedTestError;
  private BigDecimal transferRateInMBit;
  private String errorMessage;

  public SpeedValueListener(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void onCompletion(SpeedTestReport report) {
    transferRateInMBit =
        report.getTransferRateBit().divide(BigDecimal.valueOf(1_000_000), RoundingMode.HALF_DOWN);
    countDownLatch.countDown();
  }

  @Override
  public void onError(SpeedTestError speedTestError, String errorMessage) {
    this.speedTestError = speedTestError;
    this.errorMessage = errorMessage;
    countDownLatch.countDown();
  }

  @Override
  public void onProgress(float percent, SpeedTestReport report) {
    // Do nothing
  }
}
