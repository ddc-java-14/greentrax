package edu.cnm.deepdive.greentrax.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

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

  @NonNull
  @Expose
  private String name;

  @NonNull
  @Expose
  private Long amount;

  @NonNull
  @Expose
  private String note;



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

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public Long getAmount() {
    return amount;
  }

  public void setAmount(@NonNull Long amount) {
    this.amount = amount;
  }

  @NonNull
  public String getNote() {
    return note;
  }

  public void setNote(@NonNull String note) {
    this.note = note;
  }
}
