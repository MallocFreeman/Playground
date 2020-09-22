package de.drauschke.SpeedtestService.speedservices;

import org.junit.jupiter.api.Test;

class DownstreamServiceTest {


    @Test
    public void testDownload() {
        DownstreamService downstreamService = new DownstreamService();
        downstreamService.downloadSpeed();
    }
}
