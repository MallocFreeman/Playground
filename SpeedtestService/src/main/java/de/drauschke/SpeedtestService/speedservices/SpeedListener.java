package de.drauschke.SpeedtestService.speedservices;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;

import java.math.BigDecimal;

/**
 * Abstract class for defining actions that shall be done while a JSpeedTest is running. Depending
 * on the type of speedtest the correct SpeedTestListener must be used. See {@link
 * DownloadSpeedListener} or {@link UploadSpeedListener}.
 */
public abstract class SpeedListener implements ISpeedTestListener {

  @Override
  public void onCompletion(SpeedTestReport report) {
    BigDecimal transferRateOctet = report.getTransferRateOctet();
    BigDecimal transferRateBit = report.getTransferRateBit();

    persistResult(transferRateOctet, transferRateBit);
    System.out.println("[COMPLETED] rate in octet/s : " + transferRateOctet);
    System.out.println("[COMPLETED] rate in bit/s   : " + transferRateBit);
  }

  @Override
  public void onProgress(float percent, SpeedTestReport report) {
    System.out.println("[PROGRESS] progress : " + percent + "%");
    System.out.println("[PROGRESS] rate in octet/s : " + report.getTransferRateOctet());
    System.out.println("[PROGRESS] rate in bit/s   : " + report.getTransferRateBit());
  }

  @Override
  public void onError(SpeedTestError speedTestError, String errorMessage) {
    createErrorMessage(speedTestError);
  }

  abstract void persistResult(BigDecimal transferRateOctet, BigDecimal transferRateBit);

  abstract String createErrorMessage(SpeedTestError speedTestError);
}
