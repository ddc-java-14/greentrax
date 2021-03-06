package edu.cnm.deepdive.greentrax.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface AccountDao {

  @Insert
  Single<Long> insert(Account account);

  @Insert
  Single<List<Long>> insert(Account... accounts);

  @Insert
  Single<List<Long>> insert(Collection<Account> accounts);

  @Update
  Single<Integer> update(Account account);

  @Update
  Single<Integer> update(Account... accounts);

  @Update
  Single<Integer> update(Collection<Account> accounts);

  @Delete
  Single<Integer> delete(Account account);

  @Delete
  Single<Integer> delete(Account... accounts);

  @Delete
  Single<Integer> delete(Collection<Account> accounts);

  @Query("SELECT * FROM account WHERE account_id = :accountId")
  LiveData<Account> select(long accountId);

  @Query("SELECT * FROM account ORDER BY name ASC")
  LiveData<List<Account>> select();

}
