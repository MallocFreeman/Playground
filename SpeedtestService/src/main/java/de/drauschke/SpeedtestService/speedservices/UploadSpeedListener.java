package de.drauschke.SpeedtestService.speedservices;

import fr.bmartel.speedtest.model.SpeedTestError;

import java.math.BigDecimal;

/** Specialized SpeedListener for uploads */
public class UploadSpeedListener extends SpeedListener {
  @Override
  void persistResult(BigDecimal transferRateOctet, BigDecimal transferRateBit) {
    // TODO Persist upload value
  }

  @Override
  String createErrorMessage(SpeedTestError speedTestError) {
    // TODO do some error handling
    return null;
  }
}
