package de.drauschke.HomeNetworkService.speedtest.persistence;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Delegator class to encapsulate the used persistence layer. Transforms the auto generated models
 * from the OpenApi into hibernate entities to persist them.
 */
@Component
@AllArgsConstructor
public class SpeedtestResultPersister {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpeedtestResultPersister.class);
  private final SpeedtestResultRepository speedtestResultRepository;

  /**
   * Persists a {@link SpeedtestResult}
   *
   * @param speedtestResult result to persist
   */
  public void persist(SpeedtestResult speedtestResult) {
    LOGGER.debug("Persisting result:" + speedtestResult.toString());
    speedtestResultRepository.save(SpeedtestModelMapper.mapToEntity(speedtestResult));
  }
}
