package edu.cnm.deepdive.greentrax.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import edu.cnm.deepdive.greentrax.service.TransactionRepository;
import io.reactivex.disposables.CompositeDisposable;

public class BudgetViewModel extends AndroidViewModel implements DefaultLifecycleObserver {

  private final TransactionRepository repository;
  private final MutableLiveData<Transaction> transaction;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;



  public BudgetViewModel(@NonNull Application application) {
    super(application);
    repository = new TransactionRepository(application);
    transaction = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  public void save(Transaction transaction) {
    throwable.setValue(null);
    pending.add(
        repository
            .save(transaction, null)
            .subscribe(
                this.transaction::postValue,
                this::postThrowable
            )
    );

  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    DefaultLifecycleObserver.super.onStop(owner);
    pending.clear();
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

}
