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
    tableName = "budget",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = Account.class,
            parentColumns = {"account_id"},
            childColumns = {"account_id"},
            onDelete = ForeignKey.RESTRICT
        )
    }


)
public class Budget {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "budget_id")
  private long id;

  @ColumnInfo(name = "account_id", index = true)
  private long accountId;


  @Expose
  @SerializedName("id")
  @ColumnInfo(name = "service_key")
  private String serviceKey;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Date created;



  @Expose
  private int amount;

  @NonNull
  @Expose
  private String type;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getServiceKey() {
    return serviceKey;
  }

  public void setServiceKey(String serviceKey) {
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



  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
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
