package com.example.background_task;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.background_task.R;
import com.example.background_task.User;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final ArrayList<User> mUserList;
    private Context context;

    public UserListAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View mItemView = mInflater.inflate(R.layout.items, parent, false);
        return new UserViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String mCurrent = mUserList.get(position).name;
        holder.tvUserName.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvUserName;
        final UserListAdapter mAdapter;

        public UserViewHolder(View itemView, UserListAdapter adapter) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.userName);
            this.mAdapter = adapter;
            itemView.setOnClickListener(view -> {
                int pos = getLayoutPosition();
                User user2 = mUserList.get(pos);
//                Toast.makeText(context.getApplicationContext(),""+ mUserList.get(pos).id, Toast.LENGTH_SHORT).show();
                Intent i =  new Intent(context.getApplicationContext(),MainActivity3.class);

                i.putExtra("id",mUserList.get(pos).id);
                i.putExtra("name",mUserList.get(pos).name);
                i.putExtra("gender",mUserList.get(pos).gender);
                i.putExtra("status",mUserList.get(pos).status);
                i.putExtra("email",mUserList.get(pos).email);
                context.startActivity(i);
            });
        }
    }
}