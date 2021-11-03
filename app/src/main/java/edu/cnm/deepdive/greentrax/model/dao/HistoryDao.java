package edu.cnm.deepdive.greentrax.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.greentrax.model.entity.History;
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

  @Query("SELECT * FROM history ORDER BY created  DESC")
  LiveData<List<History>> selectAll();

  @Query("SELECT * FROM history WHERE history_id = :historyId")
  LiveData<History> select(long historyId);

}
