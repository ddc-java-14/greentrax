package edu.cnm.deepdive.greentrax.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

@Entity(
    tableName = "transaction",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = Account.class,
            parentColumns = {"account_id"},
            childColumns = {"account_id"},
            onDelete = ForeignKey.RESTRICT
        ),
        @ForeignKey(
            entity = Budget.class,
            parentColumns = {"budget_id"},
            childColumns = {"budget_id"},
            onDelete = ForeignKey.SET_NULL
        )
    }

)
public class Transaction {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "transaction_id")
  private long id;

  @ColumnInfo(name = "account_id", index = true)
  private long accountId;

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

  @NonNull
  @Expose
  private String name;


  @Expose
  private int amount;

  @NonNull
  @Expose
  private String note;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
  }

  public long getBudgetId() {
    return budgetId;
  }

  public void setBudgetId(long budgetId) {
    this.budgetId = budgetId;
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


  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
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
