package edu.cnm.deepdive.greentrax.service;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.greentrax.model.dao.AccountDao;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;

public class AccountRepository {

  private final Application context;
  private final AccountDao accountDao;

  public AccountRepository(Application context) {
    this.context = context;
    accountDao = AccountDatabase
        .getInstance()
        .getAccountDao();
  }

  public LiveData<Account> get(long accountId) {return accountDao.select(accountId);
  }

  public LiveData<List<Account>> getAll() {
    return accountDao.select();
  }


  //This is our save method which saves a note in the database
  public Single<Account> save(Account account) {
    Single<Account> task;
    account.setCreated(new Date());
    if (account.getId() == 0) {
      account.setCreated(account.getCreated());
      task = accountDao
          .insert(account)
          .map((id) -> {
            account.setId(id);
            return account;
          });

    } else {
      task = accountDao
          .update(account)
          .map((count) -> account);
    }

    return task.subscribeOn(Schedulers.io());
  }

  //This is our delete method which will delete a note from the database/repository
  public Completable delete(Account account) {
    return (account.getId() == 0)
        ? Completable.complete()
        : accountDao
            .delete(account)
            .ignoreElement()
            .subscribeOn(Schedulers.io());
  }


  

}
