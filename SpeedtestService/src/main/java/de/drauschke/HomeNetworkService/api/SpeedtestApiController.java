package de.drauschke.HomeNetworkService.api;

import de.drauschke.HomeNetworkService.model.Error;
import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.SpeedtestExecutor;
import de.drauschke.HomeNetworkService.speedtest.SpeedtestHistoryService;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.SpeedEvaluationException;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-10-26T20:21:52.118154+01:00[Europe/Berlin]")
@Controller
@AllArgsConstructor
@RequestMapping("${openapi.HomeNetworkService.base-path:/homeNetwork}")
public class SpeedtestApiController implements SpeedtestApi {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpeedtestApiController.class);
  private final NativeWebRequest request;
  private final SpeedtestExecutor speedtestExecutor;
  private final SpeedtestHistoryService speedtestHistoryService;

  /**
   * GET /speedtest Measures the results of an successful speedtest and persists the result.
   *
   * @return Indicates that the speedtest was successful and returns its result. (status code 200)
   *     or Indicates that an serverside error occured. The speedtest was not successful and no
   *     result is returned. (status code 500)
   * @see SpeedtestApi#speedtestGet
   */
  public ResponseEntity<SpeedtestResult> speedtestGet() {
    try {
      return new ResponseEntity(speedtestExecutor.execute(), HttpStatus.OK);
    } catch (SpeedEvaluationException | InterruptedException exception) {
      Error error = new Error();
      error.setMessage(exception.getMessage());
      error.setCode(exception.getStackTrace().toString());
      return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * GET /speedtest-history Get history data of executed Speedtests if available.
   *
   * @param month Specifies the month for the retrieved history data. (required)
   * @param year Specifies the year for the retrieved history data. (required)
   * @return Indicates that the history was retrieved successful. (status code 200) or Indicates
   *     that an serverside error occured. The speedtest was not successful and no result is
   *     returned. (status code 500)
   * @see SpeedtestApi#speedtestHistoryGet
   */
  public ResponseEntity<List<SpeedtestResult>> speedtestHistoryGet(
      @NotNull
          @ApiParam(
              value = "Specifies the month for the retrieved history data.",
              required = true,
              allowableValues = "Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec",
              defaultValue = "Jan")
          @Valid
          @RequestParam(value = "month", required = true, defaultValue = "Jan")
          String month,
      @NotNull
          @Min(2020)
          @ApiParam(
              value = "Specifies the year for the retrieved history data.",
              required = true,
              defaultValue = "2020")
          @Valid
          @RequestParam(value = "year", required = true, defaultValue = "2020")
          Integer year) {

    return new ResponseEntity<>(speedtestHistoryService.getHistory(), HttpStatus.OK);
  }
}
