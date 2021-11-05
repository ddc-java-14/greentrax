package edu.cnm.deepdive.greentrax.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.greentrax.model.entity.Budget;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface BudgetDao {

  @Insert
  Single<Long> insert(Budget budget);

  @Insert
  Single<List<Long>> insert(Budget... budgets);

  @Insert
  Single<List<Long>> insert(Collection<Budget> budgets);

  @Update
  Single<Integer> update(Budget budget);

  @Update
  Single<Integer> update(Budget... budgets);

  @Update
  Single<Integer> update(Collection<Budget> budgets);

  @Delete
  Single<Integer> delete(Budget budget);

  @Delete
  Single<Integer> delete(Budget... budgets);

  @Delete
  Single<Integer> delete(Collection<Budget> budgets);

  @Query("SELECT * FROM budget WHERE budget_id = :budgetId")
  LiveData<Budget> budgetData(long budgetId);

  @Query("SELECT * FROM `transaction` WHERE transaction_id = :transactionId")
  LiveData<Transaction> transactionData(long transactionId);


}
