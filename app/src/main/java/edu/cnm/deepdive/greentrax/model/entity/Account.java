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
  private Long userId;


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


  @Expose
  private int amount;




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
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


  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = Math.toIntExact(amount);
  }
}
