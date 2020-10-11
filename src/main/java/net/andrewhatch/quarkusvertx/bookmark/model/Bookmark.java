package net.andrewhatch.quarkusvertx.bookmark.model;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

@Entity
public class Bookmark {

  @PartitionKey
  private String accountId;

  @ClusteringColumn(0)
  private String folderId;

  @ClusteringColumn(1)
  private String url;

  private String label;

  public Bookmark() {
  }

  public Bookmark(
      String accountId,
      String folderId,
      String label,
      String url
  ) {
    this.accountId = accountId;
    this.folderId = folderId;
    this.label = label;
    this.url = url;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getFolderId() {
    return folderId;
  }

  public void setFolderId(String folderId) {
    this.folderId = folderId;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
