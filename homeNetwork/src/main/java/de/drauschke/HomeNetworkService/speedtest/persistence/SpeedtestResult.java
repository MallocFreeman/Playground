package de.drauschke.HomeNetworkService.speedtest.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * Entity for the result set of an executed speedtest. The database table is called
 * 'speedtest_result'
 */
@Entity
@Data
public class SpeedtestResult {
  @Id private String timestamp;
  private Integer upload;
  private Integer download;
}
