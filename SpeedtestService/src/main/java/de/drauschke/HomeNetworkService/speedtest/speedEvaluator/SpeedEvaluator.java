package de.drauschke.HomeNetworkService.speedtest.speedEvaluator;

import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.model.SpeedTestError;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Provides the usage of the used JSpeedTest library and provides the values of a speed rate
 * evaluation.
 */
@AllArgsConstructor
public abstract class SpeedEvaluator {
  private static final long LATCH_TIMEOUT_SECONDS = 60;
  private static final TimeUnit LATCH_TIMEOUT_UNIT = TimeUnit.SECONDS;

  private final int socketTimeout;

  /**
   * Starts a new speedtest with predefined parameters of the child class.
   *
   * @return the speedtest result rate as {@link BigDecimal}
   * @throws SpeedEvaluationException if the speedtest runs into an error or another error while
   *     execution happens.
   */
  public synchronized BigDecimal evaluate() throws SpeedEvaluationException, InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    SpeedValueListener speedValueListener = new SpeedValueListener(countDownLatch);
    evaluateSpeed(createSpeedTestSocket(speedValueListener));
    countDownLatch.await(LATCH_TIMEOUT_SECONDS, LATCH_TIMEOUT_UNIT);
    validateResult(speedValueListener);
    return speedValueListener.getTransferRateInMBit();
  }

  /**
   * Calls the delegation method to run the defined speedtest method in the child class.
   *
   * @param speedTestSocket the {@link SpeedTestSocket} object on which the speedtest is executed.
   */
  abstract void evaluateSpeed(SpeedTestSocket speedTestSocket);

  private void validateResult(SpeedValueListener speedValueListener)
      throws SpeedEvaluationException {
    SpeedTestError speedTestError = speedValueListener.getSpeedTestError();
    String errorMessage = speedValueListener.getErrorMessage();

    if (speedTestError != null || !StringUtils.isEmpty(errorMessage)) {
      throw new SpeedEvaluationException(speedTestError, errorMessage);
    }
  }

  private SpeedTestSocket createSpeedTestSocket(SpeedValueListener speedValueListener) {
    SpeedTestSocket speedTestSocket = new SpeedTestSocket();
    speedTestSocket.setSocketTimeout(socketTimeout);
    speedTestSocket.addSpeedTestListener(speedValueListener);
    return speedTestSocket;
  }
}
