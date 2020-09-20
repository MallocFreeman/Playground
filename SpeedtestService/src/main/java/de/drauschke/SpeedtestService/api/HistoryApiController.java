package de.drauschke.SpeedtestService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.drauschke.SpeedtestService.model.HistoryElements;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
@Controller
public class HistoryApiController implements HistoryApi {

  private static final Logger log = LoggerFactory.getLogger(HistoryApiController.class);

  private final ObjectMapper objectMapper;

  private final HttpServletRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public HistoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.objectMapper = objectMapper;
    this.request = request;
  }

  public ResponseEntity<HistoryElements> historyGet(
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
          Integer year) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<HistoryElements>(
            objectMapper.readValue(
                "[ {\n  \"download\" : 0,\n  \"upload\" : 6,\n  \"timestamp\" : \"timestamp\"\n}, {\n  \"download\" : 0,\n  \"upload\" : 6,\n  \"timestamp\" : \"timestamp\"\n} ]",
                HistoryElements.class),
            HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<HistoryElements>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<HistoryElements>(HttpStatus.NOT_IMPLEMENTED);
  }
}
