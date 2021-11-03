package edu.cnm.deepdive.greentrax.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import edu.cnm.deepdive.greentrax.model.entity.Budget;
import edu.cnm.deepdive.greentrax.model.entity.History;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import edu.cnm.deepdive.greentrax.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface HistoryDao {

  @Insert
  Single<Long> insert(History history);

  @Insert
  Single<List<Long>> insert(History... histories);

  @Insert
  Single<List<Long>> insert(Collection<History> histories);

  @Update
  Single<Integer> update(History history);

  @Update
  Single<Integer> update(History... histories);

  @Update
  Single<Integer> update(Collection<History> histories);

  @Delete
  Single<Integer> delete(History history);

  @Delete
  Single<Integer> delete(History... histories);

  @Delete
  Single<Integer> delete(Collection<History> histories);

  @Query("SELECT * FROM user ORDER BY created  DESC")
  LiveData<List<User>> selectAll();

  @Query("SELECT * FROM account WHERE account_id = :accountId")
  LiveData<Account> accountData(long accountId);

  @Query("SELECT * FROM `transaction` WHERE transaction_id = :transactionId")
  LiveData<Transaction> transactionData(long transactionId);

  @Query("SELECT * FROM budget WHERE budget_id = :budgetId")
  LiveData<Budget> budgetData(long budgetId);


}
