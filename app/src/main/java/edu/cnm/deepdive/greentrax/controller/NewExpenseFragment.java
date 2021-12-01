package edu.cnm.deepdive.greentrax.controller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.greentrax.R;
import edu.cnm.deepdive.greentrax.databinding.FragmentNewExpenseBinding;
import edu.cnm.deepdive.greentrax.model.entity.Transaction;
import edu.cnm.deepdive.greentrax.viewmodel.BudgetViewModel;

public class NewExpenseFragment extends DialogFragment implements TextWatcher {

  private FragmentNewExpenseBinding binding;
  private AlertDialog dialog;
  private BudgetViewModel viewModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    binding = FragmentNewExpenseBinding.inflate(LayoutInflater.from(getContext()), null, false);
    binding.amount.addTextChangedListener(this);
    dialog = new AlertDialog.Builder(getContext())
        .setIcon(R.drawable.ic_baseline_attach_money_24)
        .setTitle(R.string.new_expense_title)
        .setView(binding.getRoot())
        .setNegativeButton(android.R.string.cancel, (d, w) -> {
        })
        .setPositiveButton(getString(R.string.save_label), (d, w) -> {
          Transaction transaction = new Transaction();
          String amountInput = binding.amount.getText().toString().trim();
          double amount = Double.parseDouble(amountInput);
          transaction.setAmount((int) Math.round(amount * 100));
          transaction.setName((String) binding.category.getSelectedItem());
          transaction.setNote(binding.note.getText().toString().trim());
          viewModel.save(transaction);
        })
        .create();
    dialog.setOnShowListener(dialogInterface -> {
      /*TODO check initial field conditions for validity*/
    });
    return dialog;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(BudgetViewModel.class);
    // TODO Observe as appropriate
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    // Do Nothing
  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
  //Do Nothing
  }

  @Override
  public void afterTextChanged(Editable editable) {
  // TODO Check fields for valid entries and enable/disable the button accordingly
//    dialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(/* True or false depending on entries in the fields */);
  }
}
