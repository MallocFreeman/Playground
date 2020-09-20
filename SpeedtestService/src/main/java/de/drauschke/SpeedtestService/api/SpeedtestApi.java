package de.drauschke.SpeedtestService.api;

import de.drauschke.SpeedtestService.model.Error;
import de.drauschke.SpeedtestService.model.SpeedtestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
@Api(value = "speedtest", description = "the speedtest API")
public interface SpeedtestApi {

  @ApiOperation(
      value = "",
      nickname = "speedtestGet",
      notes = "Starts a new speedtest.",
      response = SpeedtestResult.class,
      tags = {
        "Speedtest",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "Indicates that the speedtest was successful and returns its result.",
            response = SpeedtestResult.class),
        @ApiResponse(
            code = 500,
            message =
                "Indicates that an serverside error occured. The speedtest was not successful and no result is returned.",
            response = Error.class)
      })
  @RequestMapping(
      value = "/speedtest",
      produces = {"application/json"},
      method = RequestMethod.GET)
  ResponseEntity<SpeedtestResult> speedtestGet();
}
