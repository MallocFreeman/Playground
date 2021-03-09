package de.drauschke.HomeNetworkService.speedtest.speedEvaluator;

import fr.bmartel.speedtest.model.SpeedTestError;

public class SpeedEvaluationException extends Exception {

  public SpeedEvaluationException(SpeedTestError speedTestError, String errorMessage) {
    super(speedTestError != null ? speedTestError.toString() : "" + errorMessage);
  }
}
