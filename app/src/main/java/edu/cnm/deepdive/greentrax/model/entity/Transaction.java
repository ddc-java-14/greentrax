package edu.cnm.deepdive.greentrax.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import javax.persistence.Column;

@Entity(
    tableName = "transaction",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    }
)
public class Transaction {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "transaction_id")
  private long id;

  @NonNull
  @Expose
  @SerializedName("id")
  @ColumnInfo(name = "service_key")
  private String serviceKey;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Date created;

  @Column(nullable = false, updatable = true, unique = true, length = 40)
  private String name;

  @Column(name = "account_id", nullable = false, updatable = false)
  private Account account;

  @Column(name = "category_id", nullable = false, updatable = false)
  private Category category;

  @Column(nullable = false, updatable = false, length = 2000)
  private String note;

  @Column(nullable = false, updatable = false, length = 100)
  private String amount;

  @Column(nullable = false, updatable = false, length = 100)
  private String type;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getServiceKey() {
    return serviceKey;
  }

  public void setServiceKey(@NonNull String serviceKey) {
    this.serviceKey = serviceKey;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
