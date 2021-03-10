package de.drauschke.HomeNetworkService.speedtest;

import de.drauschke.HomeNetworkService.model.SpeedtestResult;
import de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResultPersister;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.DownloadSpeedEvaluator;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.SpeedEvaluationException;
import de.drauschke.HomeNetworkService.speedtest.speedEvaluator.UploadSpeedEvaluator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpeedtestExecutorTest {
  @Mock private UploadSpeedEvaluator uploadSpeedEvaluatorMock;
  @Mock private DownloadSpeedEvaluator downloadSpeedEvaluatorMock;
  @Mock private SpeedtestResultPersister speedtestResultPersisterMock;
  private SpeedtestExecutor speedtestExecutor;

  @BeforeEach
  void init() {
    speedtestExecutor =
        new SpeedtestExecutor(
            uploadSpeedEvaluatorMock, downloadSpeedEvaluatorMock, speedtestResultPersisterMock);
  }

  @Test
  void execute() throws InterruptedException, SpeedEvaluationException {
    Mockito.when(uploadSpeedEvaluatorMock.evaluate()).thenReturn(new BigDecimal(10));
    Mockito.when(downloadSpeedEvaluatorMock.evaluate()).thenReturn(new BigDecimal(50));
    SpeedtestResult result = speedtestExecutor.execute();
    Mockito.verify(speedtestResultPersisterMock).persist(Mockito.any(SpeedtestResult.class));
    Assertions.assertEquals(50, result.getDownload());
    Assertions.assertEquals(10, result.getUpload());
    Assertions.assertNotNull(result.getTimestamp());
  }
}
