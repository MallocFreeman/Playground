package de.drauschke.SpeedtestService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/** SpeedtestResult */
@Validated
@javax.annotation.Generated(
    value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
    date = "2020-09-17T18:49:29.017Z[GMT]")
public class SpeedtestResult {
  @JsonProperty("download")
  private Integer download = null;

  @JsonProperty("upload")
  private Integer upload = null;

  @JsonProperty("timestamp")
  private String timestamp = null;

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
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
