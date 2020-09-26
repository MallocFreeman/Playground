package de.drauschke.SpeedtestService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.drauschke.SpeedtestService.model.SpeedtestResult;
import de.drauschke.SpeedtestService.speedservice.speedEvaluator.DownloadSpeedEvaluator;
import de.drauschke.SpeedtestService.speedservice.speedEvaluator.UploadSpeedEvaluator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
@Controller
@AllArgsConstructor
public class SpeedtestApiController implements SpeedtestApi {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpeedtestApiController.class);

  private final ObjectMapper objectMapper;
  private final HttpServletRequest request;
  private final UploadSpeedEvaluator uploadSpeedEvaluator;
  private final DownloadSpeedEvaluator downloadSpeedEvaluator;

  public ResponseEntity<SpeedtestResult> speedtestGet() {
    BigDecimal uploadSpeedRate = null;
    BigDecimal downloadSpeedRate = null;
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    try {
      uploadSpeedRate = uploadSpeedEvaluator.evaluate();
      downloadSpeedRate = downloadSpeedEvaluator.evaluate();
      httpStatus = HttpStatus.OK;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<SpeedtestResult>(
        createResult(uploadSpeedRate, downloadSpeedRate), HttpStatus.OK);
  }

  private SpeedtestResult createResult(BigDecimal uploadSpeedValue, BigDecimal downloadSpeedValue) {
    SpeedtestResult speedtestResult = new SpeedtestResult();
    speedtestResult.setTimestamp(new Timestamp(System.currentTimeMillis()).toString());
    speedtestResult.setDownload(downloadSpeedValue.intValue());
    speedtestResult.setUpload(uploadSpeedValue.intValue());
    return speedtestResult;
  }
}
