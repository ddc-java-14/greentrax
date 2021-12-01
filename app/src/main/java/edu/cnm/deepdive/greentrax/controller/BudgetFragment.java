package edu.cnm.deepdive.greentrax.controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.greentrax.R;
import edu.cnm.deepdive.greentrax.databinding.FragmentBudgetBinding;

public class BudgetFragment extends Fragment {


  private FragmentBudgetBinding binding;
  // TODO Declare viewmodel and other fields


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentBudgetBinding.inflate(inflater, container, false);
    binding.addExpense.setOnClickListener((v) -> Navigation.findNavController(binding.getRoot())
        .navigate(BudgetFragmentDirections.openNewExpense()));
    // TODO Attach event listeners
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TODO Attach to view models
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void additem() {
    AlertDialog.Builder myDialog = new AlertDialog.Builder(getContext());
    LayoutInflater inflater = LayoutInflater.from(getContext());
    View myView = inflater.inflate(R.layout.fragment_new_expense, null);
    myDialog.setView(myView);

    final AlertDialog dialog = myDialog.create();
    dialog.setCancelable(false);

    final Spinner itemSpinner = myView.findViewById(R.id.category);
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
          Toast.makeText(getContext(), "Select A Valid Item", Toast.LENGTH_SHORT).show();
        } else {
//          loader.setMessage("Adding a Budget Item");
//          loader.setCanceledOnTouchOutside(false);
//          loader.show();

        }
      }
    });

    dialog.show();


  }


  public class myViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ImageView imageView;
    public TextView notes;

    public myViewHolder(View itemView) {
      super(itemView);
      mView = itemView;
      imageView = itemView.findViewById(R.id.imageView);
      notes = itemView.findViewById(R.id.note);
    }

    public void setItemName(String itemName) {
      TextView item = mView.findViewById(R.id.item1);
      item.setText(itemName);
    }

    public void setItemAmount(String itemAmount) {
      TextView item = mView.findViewById(R.id.item1);
      item.setText(itemAmount);
    }

    public void setDate(String itemAmount) {
      TextView item = mView.findViewById(R.id.date);

    }


  }

}