package de.drauschke.HomeNetworkService.speedtest;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestModelMapper;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResultRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/** Service to provide history related data for {@link SpeedtestResult} */
@Service
@AllArgsConstructor
public class SpeedtestHistoryService {
  private static final Logger logger = Logger.getLogger(SpeedtestHistoryService.class.getName());

  private final SpeedtestResultRepository speedtestResultRepository;

  public List<SpeedtestResult> getHistory() {
    return sortResultByTimestamp(
        StreamSupport.stream(speedtestResultRepository.findAll().spliterator(), false)
            .map(SpeedtestModelMapper::mapToModel)
            .collect(Collectors.toList()));
  }

  private List<SpeedtestResult> sortResultByTimestamp(List<SpeedtestResult> speedtestResults) {
    TreeMap<Timestamp, SpeedtestResult> sortedResult = new TreeMap<>();

    speedtestResults.forEach(
        result ->
            convertTimestamp(result.getTimestamp())
                .ifPresent(elem -> sortedResult.put(elem, result)));

    return new ArrayList<>(sortedResult.values());
  }

  private Optional<Timestamp> convertTimestamp(String value) {
    Optional<Timestamp> timestamp = Optional.empty();
    try {
      timestamp = Optional.of(Timestamp.valueOf(value));
    } catch (IllegalArgumentException parseException) {
      logger.warning("Could not parse timestamp:" + value);
    }
    return timestamp;
  }
}
