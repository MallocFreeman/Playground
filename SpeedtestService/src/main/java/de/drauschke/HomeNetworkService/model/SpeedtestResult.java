package de.drauschke.HomeNetworkService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/** SpeedtestResult */
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-10-26T20:21:52.118154+01:00[Europe/Berlin]")
public class SpeedtestResult implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("download")
  private Integer download;

  @JsonProperty("upload")
  private Integer upload;

  @JsonProperty("timestamp")
  private String timestamp;

  public SpeedtestResult download(Integer download) {
    this.download = download;
    return this;
  }

  /**
   * Get download
   *
   * @return download
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Integer getDownload() {
    return download;
  }

  public void setDownload(Integer download) {
    this.download = download;
  }

  public SpeedtestResult upload(Integer upload) {
    this.upload = upload;
    return this;
  }

  /**
   * Get upload
   *
   * @return upload
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Integer getUpload() {
    return upload;
  }

  public void setUpload(Integer upload) {
    this.upload = upload;
  }

  public SpeedtestResult timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   *
   * @return timestamp
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpeedtestResult speedtestResult = (SpeedtestResult) o;
    return Objects.equals(this.download, speedtestResult.download)
        && Objects.equals(this.upload, speedtestResult.upload)
        && Objects.equals(this.timestamp, speedtestResult.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(download, upload, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeedtestResult {\n");

    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
