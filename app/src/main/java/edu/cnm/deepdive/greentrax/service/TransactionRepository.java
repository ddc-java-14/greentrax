package edu.cnm.deepdive.greentrax.service;

import android.content.Context;
import edu.cnm.deepdive.greentrax.model.dao.TransactionDao;
import edu.cnm.deepdive.greentrax.model.entity.Budget;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

public class TransactionRepository {

  private final Context context;
  private final TransactionDao transactionDao;

  public TransactionRepository(Context context) {
    this.context = context;
    transactionDao = GreenTraxDatabase.getInstance().getTransactionDao();
  }

  public Single<Transaction> save(Transaction transaction, Budget budget) {
    if (budget != null) {
      transaction.setBudgetId(budget.getId());
    }
    transaction.setCreated(new Date());
    return transactionDao
        .insert(transaction)
        .map((id) -> {
          transaction.setId(id);
          return transaction;
        })
        .subscribeOn(Schedulers.io());
  }

}
