package edu.cnm.deepdive.greentrax.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface TransactionDao {

  @Insert
  Single<Long> insert(Transaction transaction);

  @Insert
  Single<List<Long>> insert(Transaction... transactions);

  @Insert
  Single<List<Long>> insert(Collection<Transaction> transactions);

  @Update
  Single<Integer> update(Transaction transaction);

  @Update
  Single<Integer> update(Transaction... transactions);

  @Update
  Single<Integer> update(Collection<Transaction> transactions);

  @Delete
  Single<Integer> delete(Transaction transaction);

  @Delete
  Single<Integer> delete(Transaction... transactions);

  @Delete
  Single<Integer> delete(Collection<Transaction> transactions);

  @Query("SELECT * FROM `transaction` WHERE transaction_id = :transactionId")
  LiveData<Transaction> transactionData(long transactionId);

}
