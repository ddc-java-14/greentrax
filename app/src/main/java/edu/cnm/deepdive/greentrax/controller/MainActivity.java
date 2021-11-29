package edu.cnm.deepdive.greentrax.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.greentrax.MobileNavigationDirections;
import edu.cnm.deepdive.greentrax.R;
import edu.cnm.deepdive.greentrax.databinding.ActivityMainBinding;
import edu.cnm.deepdive.greentrax.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;
  private LoginViewModel loginViewModel;
  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    getLifecycle().addObserver(loginViewModel);
    loginViewModel.getAccount().observe(this, (account) -> {
      if (account == null) {
        Intent intent = new Intent(this, LoginActivity.class)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
      }
    });
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
//
//   // setSupportActionBar(binding.appBarMain.toolbar);
//    DrawerLayout drawer = binding.drawerLayout;
//    NavigationView navigationView = binding.navView;

    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.

    appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_account, R.id.nav_transaction)
//        .setDrawerLayout(drawer)
        .build();
    navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//    NavigationUI.setupWithNavController(navController);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled;
    int itemId = item.getItemId();
    if (itemId == R.id.sign_out) {
      loginViewModel.signOut();
      handled = true;
    } else if (itemId == R.id.action_settings) {
      navController.navigate(MobileNavigationDirections.openSettings());
      handled = true;
    } else {
      handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this,
        R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }
}