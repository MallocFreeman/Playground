package de.drauschke.SpeedtestService.speedservices;

import fr.bmartel.speedtest.model.SpeedTestError;

import java.math.BigDecimal;

/** Specialized SpeedListener for downloads */
public class DownloadSpeedListener extends SpeedListener {

  @Override
  void persistResult(BigDecimal transferRateOctet, BigDecimal transferRateBit) {
      // TODO Persist download value
  }

  @Override
  String createErrorMessage(SpeedTestError speedTestError) {
      // TODO do some error handling
    return null;
  }
}
