package de.drauschke.HomeNetworkService.speedtest.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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
