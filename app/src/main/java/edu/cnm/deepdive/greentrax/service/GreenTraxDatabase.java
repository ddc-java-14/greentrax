package edu.cnm.deepdive.greentrax.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.greentrax.model.dao.AccountDao;
import edu.cnm.deepdive.greentrax.model.dao.BudgetDao;
import edu.cnm.deepdive.greentrax.model.dao.TransactionDao;
import edu.cnm.deepdive.greentrax.model.dao.UserDao;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import edu.cnm.deepdive.greentrax.model.entity.Budget;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import edu.cnm.deepdive.greentrax.model.entity.User;
import edu.cnm.deepdive.greentrax.service.GreenTraxDatabase.Converters;
import java.util.Date;

@Database(
    entities = {User.class, Account.class, Transaction.class, Budget.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class GreenTraxDatabase extends RoomDatabase {

  private static Application context;

  public static void setContext(Application context) {
    GreenTraxDatabase.context = context;
  }

  public abstract UserDao getUserDao();
  public abstract AccountDao getAccountDao();
  public abstract TransactionDao getTransactionDao();
  public abstract BudgetDao budgetDao();

  public static GreenTraxDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final GreenTraxDatabase INSTANCE =
        Room.databaseBuilder(context, GreenTraxDatabase.class, "greentrax-db")
            .build();

  }
  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;

    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}
