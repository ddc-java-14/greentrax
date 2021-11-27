package edu.cnm.deepdive.greentrax.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.greentrax.databinding.FragmentEditAccountBinding;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import edu.cnm.deepdive.greentrax.viewmodel.AccountViewModel;

public class TransactionFragment extends BottomSheetDialogFragment implements TextWatcher {

  private FragmentEditAccountBinding binding;
  private AccountViewModel viewModel;
  private long accountId;
  private Account account;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TransactionFragment args = TransactionFragment.fromBundle(getArguments());
    accountId = args.getAccountId();
  }

  private static TransactionFragment fromBundle(Bundle arguments) {
    return null;
  }
  private int getAccountId() {
    return 0;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentEditAccountBinding.inflate(inflater, container, false);
    binding.name.addTextChangedListener(this);
    binding.type.addTextChangedListener(this);
    binding.cancel.setOnClickListener((v) -> dismiss());
    binding.save.setOnClickListener((v) -> {
      account.setName(binding.name.getText().toString().trim());
      account.setType(binding.type.getText().toString().trim());
      viewModel.save(account);
      dismiss();
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(AccountViewModel.class);
    if (accountId != 0) {
     viewModel.setAccountId(accountId);
     viewModel.getAccount().observe(getViewLifecycleOwner(), (account) -> {
       this.account = account;
       binding.name.setText(account.getName());
       binding.type.setText(account.getType());
     });
    } else {
      account = new Account();
    }

  }


  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    // Do nothing.
  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    //Do nothing.
  }

  //We will enable our button if neither is empty
  @Override
  public void afterTextChanged(Editable editable) {
    checkSubmitConditions();
  }

  private void checkSubmitConditions() {
    String subject = binding.name
        .getText()
        .toString()
        .trim();
    String text = binding.type
        .getText()
        .toString()
        .trim();
    binding.save.setEnabled(!subject.isEmpty() && !text.isEmpty());
  }
}