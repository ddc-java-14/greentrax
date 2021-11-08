package edu.cnm.deepdive.greentrax.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import edu.cnm.deepdive.greentrax.service.AccountRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class AccountViewModel extends AndroidViewModel implements LifecycleObserver {

  private final AccountRepository repository;
  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Long> accountId;
  private final LiveData<Integer> account;
  private final CompositeDisposable pending;


  //This is the constructor matching the super
  //Empty angle brackets allow the compiler to infer from the declaration from above.
  public AccountViewModel(@NonNull Application application,
      AccountRepository repository,
      MutableLiveData<Throwable> throwable,
      MutableLiveData<Long> accountId,
      LiveData<Integer> account, CompositeDisposable pending) {
    super(application);
    repository = new AccountRepository(application);
    throwable = new MutableLiveData<>();
    accountId = new MutableLiveData<>();
    account = Transformations.switchMap(accountId, repository::get);
    pending = new CompositeDisposable();
  }


  public LiveData<Integer> getAccounts() {
    return account;
  }

  public void setAccountId(int id) {
    account.setValue(id);
  }

  public LiveData<List<Account>> getAccount() {
    return repository.getAll();
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void save(Account account) {
    pending.add(
        repository
            .save(account)
            .subscribe(
                (savedNote) -> {
                },
                this::postThrowable

            )
    );
  }

  public void delete(Account account) {
    pending.add(
        repository
            .delete(account)
            .subscribe(
                () -> {},
                this ::postThrowable
            )
    );
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}

