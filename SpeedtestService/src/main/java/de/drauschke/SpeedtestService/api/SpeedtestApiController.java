package de.drauschke.SpeedtestService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.drauschke.SpeedtestService.model.SpeedtestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
@Controller
public class SpeedtestApiController implements SpeedtestApi {

  private static final Logger log = LoggerFactory.getLogger(SpeedtestApiController.class);

  private final ObjectMapper objectMapper;

  private final HttpServletRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public SpeedtestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.objectMapper = objectMapper;
    this.request = request;
  }

  public ResponseEntity<SpeedtestResult> speedtestGet() {
    return new ResponseEntity<SpeedtestResult>(HttpStatus.OK);
  }
}
