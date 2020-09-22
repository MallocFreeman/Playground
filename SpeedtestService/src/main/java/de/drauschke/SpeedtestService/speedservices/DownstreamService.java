package de.drauschke.SpeedtestService.speedservices;

import fr.bmartel.speedtest.SpeedTestSocket;
import org.springframework.stereotype.Service;

@Service
public class DownstreamService {

  public void downloadSpeed() {
    boolean proxy = false;
    String uri = "http://ipv4.ikoula.testdebit.info/1M.iso";
    SpeedTestSocket speedTestSocket = new SpeedTestSocket();
    speedTestSocket.addSpeedTestListener(new DownloadSpeedListener());

    if (proxy) {
      speedTestSocket.setProxyServer("http://216.56.48.118:9000");
    }

    speedTestSocket.setDownloadSetupTime(5000);
    speedTestSocket.setSocketTimeout(5000);
    speedTestSocket.startDownload(uri);
    speedTestSocket.shutdownAndWait();
  }
}
