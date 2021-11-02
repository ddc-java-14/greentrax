package edu.cnm.deepdive.greentrax.model.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Account {

  @Id
  @GeneratedValue
  @Column(name = "account_id", updatable = false, columnDefinition = "UUID")
  private UUID id;

  @Column(nullable = false, updatable = false, columnDefinition = "UUID", unique = true)
  private UUID externalKey = UUID.randomUUID();

  @CreationTimestamp
  @Temporal(value = TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @Column(nullable = false, updatable = true, unique = true, length = 40)
  private String name;

  @Column(name = "category_id", nullable = false, updatable = false)
  private Category category;

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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

}
