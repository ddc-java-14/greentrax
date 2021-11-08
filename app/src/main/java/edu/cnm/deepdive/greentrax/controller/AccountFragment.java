package edu.cnm.deepdive.greentrax.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.greentrax.adapter.AccountAdapter;
import edu.cnm.deepdive.greentrax.databinding.FragmentAccountBinding;
import edu.cnm.deepdive.greentrax.viewmodel.AccountViewModel;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    private AccountViewModel viewModel;

    @Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      binding = FragmentAccountBinding.inflate(inflater, container, false);
      binding.addAccount.setOnClickListener((v) -> Navigation
          .findNavController(binding.getRoot())
          .navigate(AccountFragmentDirections.openAccount()));
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      viewModel = new ViewModelProvider(this).get(AccountViewModel.class);
      viewModel
          .getAccount()
          .observe(getViewLifecycleOwner(), (notes) -> {
            AccountAdapter adapter = new AccountAdapter(getContext(), notes);
            binding.accounts.setAdapter(adapter);
          });
    }

    @Override
    public void onDestroyView() {
      super.onDestroyView();
      binding = null;
    }

  }
