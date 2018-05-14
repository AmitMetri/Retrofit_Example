package com.amit.retrofit_example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dell on 5/12/2018.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder>{




    private  Context context;
    private User[] data;
    GithubAdapter(Context context, User[] data){
        this.context= context;
        this.data= data;
    }


    class GithubViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        GithubViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public GithubAdapter.GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item_layout, parent ,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {
        User user = data[position];
        holder.textView.setText(user.getLogin());
        Glide.with(holder.imageView.getContext()).load(user.getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


}
