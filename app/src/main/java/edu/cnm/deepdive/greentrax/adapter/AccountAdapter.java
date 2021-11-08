package edu.cnm.deepdive.greentrax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.greentrax.databinding.ItemAccountBinding;
import edu.cnm.deepdive.greentrax.model.entity.Account;
import java.text.DateFormat;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.Holder> {

  private final LayoutInflater inflater;
  private final DateFormat dateFormat;
  private final List<Account> accounts;

  public AccountAdapter(Context context, List <Account> accounts) {
    inflater = LayoutInflater.from(context);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    this.accounts = accounts;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(ItemAccountBinding.inflate(inflater, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return accounts.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemAccountBinding binding;

    private Holder(@NonNull ItemAccountBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    //Taking setText data and putting it in our view object
    private void bind(int position) {
      Account account = accounts.get(position);
      binding.name.setText(account.getName());
      binding.created.setText(dateFormat.format(account.getCreated()));
      binding.type.setText(account.getType());
    }
  }

}