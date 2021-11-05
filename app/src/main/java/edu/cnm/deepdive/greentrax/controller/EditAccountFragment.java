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
import edu.cnm.deepdive.greentrax.databinding.FragmentAccountBinding;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import edu.cnm.deepdive.greentrax.viewmodel.AccountViewModel;

public class EditAccountFragment extends BottomSheetDialogFragment implements TextWatcher {

  private FragmentAccountBinding binding;
  private AccountViewModel viewModel;
  private long accountId;
  private Account account;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EditAccountFragment args = EditAccountFragment.fromBundle(getArguments());
    accountId = args.getAccountId();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentAccountBinding.inflate(inflater, container, false);
    binding.subject.addTextChangedListener(this);
    binding.text.addTextChangedListener(this);
    binding.cancel.setOnClickListener((v) -> dismiss());
    binding.save.setOnClickListener((v) -> {
      account.setSubject(binding.subject.getText().toString().trim());
      account.setText(binding.text.getText().toString().trim());
      viewModel.save(account);
      dismiss();
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(AccountViewModel.class);
    if (account != 0) {
      // TODO Set noteId in viewModel and observe viewModel.getNote().
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
    String subject = binding.subject
        .getText()
        .toString()
        .trim();
    String text = binding.text
        .getText()
        .toString()
        .trim();
    binding.save.setEnabled(!subject.isEmpty() && !text.isEmpty());
  }
}