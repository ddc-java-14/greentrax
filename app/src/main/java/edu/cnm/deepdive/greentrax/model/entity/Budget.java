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
    tableName = "budget",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    }
)
public class Budget {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "budget_id")
  private long id;

  @ColumnInfo(name = "account_id", index = true)
  private long accountId;

  @ColumnInfo(name = "transaction_id", index = true)
  private long transactionId;

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
  private Long amount;

  @NonNull
  @Expose
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

  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
  }

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  @NonNull
  public Long getAmount() {
    return amount;
  }

  public void setAmount(@NonNull Long amount) {
    this.amount = amount;
  }

  @NonNull
  public String getType() {
    return type;
  }

  public void setType(@NonNull String type) {
    this.type = type;
  }
}
