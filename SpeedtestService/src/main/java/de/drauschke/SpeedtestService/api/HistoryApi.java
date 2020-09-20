package de.drauschke.SpeedtestService.api;

import de.drauschke.SpeedtestService.model.Error;
import de.drauschke.SpeedtestService.model.HistoryElements;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
@Api(value = "history", description = "the history API")
public interface HistoryApi {

  @ApiOperation(
      value = "",
      nickname = "historyGet",
      notes = "Get history data of executed Speedtests if available.",
      response = HistoryElements.class,
      tags = {
        "Speedtest",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "Indicates that the history was retrieved successful.",
            response = HistoryElements.class),
        @ApiResponse(
            code = 500,
            message =
                "Indicates that an serverside error occured. The speedtest was not successful and no result is returned.",
            response = Error.class)
      })
  @RequestMapping(
      value = "/history",
      produces = {"application/json"},
      method = RequestMethod.GET)
  ResponseEntity<HistoryElements> historyGet(
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
              allowableValues = "",
              defaultValue = "2020")
          @Valid
          @RequestParam(value = "year", required = true, defaultValue = "2020")
          Integer year);
}
