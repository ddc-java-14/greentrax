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
    tableName = "account",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    }
)
public class Account {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "account_id")
  private long id;

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


  public long getBudgetId() {
    return budgetId;
  }

  public void setBudgetId(long budgetId) {
    this.budgetId = budgetId;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getType() {
    return type;
  }

  public void setType(@NonNull String type) {
    this.type = type;
  }
}
