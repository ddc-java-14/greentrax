package edu.cnm.deepdive.greentrax;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.greentrax.service.AccountDatabase;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class GreenTraxApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    AccountDatabase.setContext(this);
  }

}
