package de.drauschke.HomeNetworkService.speedtest.persistence;

/**
 * Due to the fact that the model is generated and the hibernate entity is annotation driven, this
 * mapper takes care of converting one object in another and vice versa.
 */
public class SpeedtestModelMapper {

  /**
   * Maps a generated model for the {@link de.drauschke.HomeNetworkService.model.SpeedtestResult}
   * used for the service API into a hibernate entity {@link SpeedtestResult}.
   *
   * @param speedtestResult the result to be mapped.
   * @return the mapped entity.
   */
  public static de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResult mapToEntity(
      de.drauschke.HomeNetworkService.model.SpeedtestResult speedtestResult) {
    de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResult entity =
        new de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResult();
    entity.setUpload(speedtestResult.getUpload());
    entity.setDownload(speedtestResult.getDownload());
    entity.setTimestamp(speedtestResult.getTimestamp());
    return entity;
  }

  /**
   * Maps an entity of a result into its counterpart generated API model.
   *
   * @param speedtestResult the entity to be mapped.
   * @return the corresponding model for API usage.
   */
  public static de.drauschke.HomeNetworkService.model.SpeedtestResult mapToModel(
      de.drauschke.HomeNetworkService.speedtest.persistence.SpeedtestResult speedtestResult) {

    de.drauschke.HomeNetworkService.model.SpeedtestResult model =
        new de.drauschke.HomeNetworkService.model.SpeedtestResult();

    model.setUpload(speedtestResult.getUpload());
    model.setDownload(speedtestResult.getDownload());
    model.setTimestamp(speedtestResult.getTimestamp());
    return model;
  }
}
