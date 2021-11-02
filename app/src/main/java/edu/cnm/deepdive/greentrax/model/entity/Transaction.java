package edu.cnm.deepdive.greentrax.model.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Transaction {

  @Id
  @GeneratedValue
  @Column(name = "transaction_id", updatable = false, columnDefinition = "UUID")
  private UUID id;

  @Column(nullable = false, updatable = false, columnDefinition = "UUID", unique = true)
  private UUID externalKey = UUID.randomUUID();

  @CreationTimestamp
  @Temporal(value = TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @Column(nullable = false, updatable = true, unique = true, length = 40)
  private String name;

  @Column(name = "account_id", nullable = false, updatable = false)
  private Account account;

  @Column(name = "category_id", nullable = false, updatable = false)
  private Category category;

  @Column(nullable = false, updatable = false, length = 2000)
  private String note;

  @Column(nullable = false, updatable = false, length = 100)
  private String amount;

  @Column(nullable = false, updatable = false, length = 100)
  private String type;


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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
