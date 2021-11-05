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
    tableName = "account",
    indices = {
        @Index(value = {"service_key"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = {"user_id"},
            childColumns = {"user_id"},
            onDelete = ForeignKey.RESTRICT
        )
    }
)
public class Account {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "account_id")
  private long id;


  @ColumnInfo(name = "user_id", index = true)
  private long userId;


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

  @NonNull
  @Expose
  private Long amount;




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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
  public String getType() {
    return type;
  }

  public void setType(@NonNull String type) {
    this.type = type;
  }

  @NonNull
  public Long getAmount() {
    return amount;
  }

  public void setAmount(@NonNull Long amount) {
    this.amount = amount;
  }
}
