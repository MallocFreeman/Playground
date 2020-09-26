package de.drauschke.SpeedtestService.speedservice.speedEvaluator;

import fr.bmartel.speedtest.SpeedTestSocket;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public abstract class SpeedEvaluator {
  private static final long LATCH_TIMEOUT_SECONDS = 60;
  private static final TimeUnit LATCH_TIMEOUT_UNIT = TimeUnit.SECONDS;

  private final int socketTimeout;

  public synchronized BigDecimal evaluate() throws Exception {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    SpeedValueListener speedValueListener = new SpeedValueListener(countDownLatch);
    evaluateSpeed(createSpeedTestSocket(speedValueListener));
    countDownLatch.await(LATCH_TIMEOUT_SECONDS, LATCH_TIMEOUT_UNIT);
    validateResult(speedValueListener);
    return speedValueListener.getTransferRateInMBit();
  }

  abstract void evaluateSpeed(SpeedTestSocket speedTestSocket);

  private void validateResult(SpeedValueListener speedValueListener) throws Exception {
    String errorMessage = speedValueListener.getErrorMessage();
    if (speedValueListener.getSpeedTestError() != null || !StringUtils.isEmpty(errorMessage)) {
      throw new Exception(errorMessage);
    }
  }

  private SpeedTestSocket createSpeedTestSocket(SpeedValueListener speedValueListener) {
    SpeedTestSocket speedTestSocket = new SpeedTestSocket();
    speedTestSocket.setSocketTimeout(socketTimeout);
    speedTestSocket.addSpeedTestListener(speedValueListener);
    return speedTestSocket;
  }
}
