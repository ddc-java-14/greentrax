package edu.cnm.deepdive.greentrax.controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.greentrax.R;

public class BudgetActivity extends AppCompatActivity {


  private RoomDatabase budgetRef;
  private FloatingActionButton fab;
  private AlertDialog loader;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_budget);

    fab = findViewById(R.id.fab);

    fab.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        additem();
      }
    });
  }

  private void additem() {
    AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
    LayoutInflater inflater = LayoutInflater.from(this);
    View myView = inflater.inflate(R.layout.input_layout, null);
    myDialog.setView(myView);

    final AlertDialog dialog = myDialog.create();
    dialog.setCancelable(false);

    final Spinner itemSpinner = myView.findViewById(R.id.item_spinner);
    final EditText amount = myView.findViewById(R.id.amount);
    final Button cancel = myView.findViewById(R.id.cancel);
    final Button save = myView.findViewById(R.id.save);

    save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        String budgetAmount = amount.getText().toString();
        String budgetItem = itemSpinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(budgetAmount)) {
          amount.setError("Amount is Required");
          return;
        }

        if (budgetItem.equals("Select Item")) {
          Toast.makeText(BudgetActivity.this, "Select A Valid Item", Toast.LENGTH_SHORT).show();
        } else {
          loader.setMessage("Adding a Budget Item");
          loader.setCanceledOnTouchOutside(false);
          loader.show();






        }
      }
    });

    dialog.show();


  }
}