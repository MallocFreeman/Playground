package de.drauschke.HomeNetworkService.speedtest;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestModelMapper;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResultRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/** Service to provide history related data for {@link SpeedtestResult} */
@Service
@AllArgsConstructor
public class SpeedtestHistoryService {
  private final SpeedtestResultRepository speedtestResultRepository;

  public List<SpeedtestResult> getHistory() {
    return StreamSupport.stream(speedtestResultRepository.findAll().spliterator(), false)
        .map(SpeedtestModelMapper::mapToModel)
        .collect(Collectors.toList());
  }
}
