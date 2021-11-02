package edu.cnm.deepdive.greentrax.model.entity;

import androidx.room.Index;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(
    name = "category",
    indexes = {
        @Index(columnList = "created")
    }
)
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "category_id", updatable = false, columnDefinition = "UUID")
  private UUID id;

  @Column(nullable = false, updatable = false, columnDefinition = "UUID", unique = true)
  private UUID externalKey = UUID.randomUUID();


  @Temporal(value = TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created = new Date();

  @Column(nullable = false, updatable = true, unique = true, length = 40)
  private String name;

  @Column(name = "account_id", nullable = false, updatable = false)
  private Account account;

  @Column(name = "transaction_id", nullable = false, updatable = false)
  private Transaction transaction;


  public UUID getId() {
    return id;
  }

  public UUID getExternalKey() {
    return externalKey;
  }

  public Date getCreated() {
    return created;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }
}
