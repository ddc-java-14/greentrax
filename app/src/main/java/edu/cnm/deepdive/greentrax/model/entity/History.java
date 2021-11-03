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
    tableName = "history",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    }
)
public class History {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "history_id")
  private long id;


  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "account_id", index = true)
  private long accountId;

  @ColumnInfo(name = "transaction_id", index = true)
  private long transactionId;

  @ColumnInfo(name = "budget_id", index = true)
  private long budgetId;

  @NonNull
  @Expose
  @SerializedName("id")
  @ColumnInfo(name = "service_key")
  private String serviceKey;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Date created;


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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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

  public long getBudgetId() {
    return budgetId;
  }

  public void setBudgetId(long budgetId) {
    this.budgetId = budgetId;
  }
}